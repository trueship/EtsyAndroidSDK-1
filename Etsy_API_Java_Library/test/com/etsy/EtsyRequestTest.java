package com.etsy;

import com.etsy.etsyCore.BaseTokenStorage;
import com.etsy.etsyCore.EtsyRequestManager;
import com.etsy.etsyCore.MapStorage;
import com.etsy.etsyCore.PermissionScope;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.scribe.model.Token;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ProxySelector;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * This class can be used as a base class for all Etsy request tests.
 *
 * This SDK uses Betamax library to record requests & replay HTTP traffic later
 * on tests. For this reason you will run test first time against live Etsy API.
 *
 * When you first start creating a set of tests you will need to run {@link EtsyRequestInitialSetupTest}
 * to get the request token.
 *
 * @author Vladimir Livin, vladimir@livesystems.ru
 */
public abstract class EtsyRequestTest {
    public static final String TEST_PROPERTIES_FILE = "test.properties";
    private static Logger log = Logger.getLogger(EtsyRequestTest.class.getName());

    private final static PermissionScope predefinedScope = new PermissionScope(new String[]{
        PermissionScope.READ_LISTINGS,
        PermissionScope.WRITE_LISTINGS,
        PermissionScope.READ_FEEDBACK,
        PermissionScope.READ_WRITE_SHOPS,
        PermissionScope.READ_BILLING,
        PermissionScope.READ_WRITE_CART,
        PermissionScope.READ_TRANSACTIONS,
        PermissionScope.WRITE_TRANSACTIONS,
        PermissionScope.READ_SHIPPING_ADDRESSES,
        PermissionScope.WRITE_SHIPPING_ADDRESSES,
        PermissionScope.READ_PROFILE,
        PermissionScope.WRITE_PROFILE,
        PermissionScope.WRITE_TREASURY,
    });

    private Properties properties;
    protected EtsyRequestManager requestManager;

    public Properties getProperties() {
        return properties;
    }

    public String getApiKey() {
        return getProperties().getProperty("apiKey", "");
    }

    public String getApiSecret() {
        return getProperties().getProperty("apiSecret", "");
    }

    public String getCallback() {
        return getProperties().getProperty("callback", "");
    }

    public PermissionScope getScope() {
        return predefinedScope;
    }

    public Token getAccessToken() {
        return new Token(getProperties().getProperty("accessToken.token", ""), getProperties().getProperty("accessToken.secret", ""));
    }

    public void setUp() {
        setupProperties();
        setupProxy();
        requestManager = createRequestManager();
    }

    private void setupProxy() {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpRoutePlanner routePlanner = new ProxySelectorRoutePlanner(
                client.getConnectionManager().getSchemeRegistry(),
                ProxySelector.getDefault()
        );
        client.setRoutePlanner(routePlanner);
    }

    public void setupProperties() {
        properties = new Properties();
        try {
            properties.load(new FileReader(new File(TEST_PROPERTIES_FILE)));
            log.info("Loaded properties from " + TEST_PROPERTIES_FILE);
        } catch (IOException e) {
            log.warning(String.format("Properties are not loaded. Ensure %s exists: %s", TEST_PROPERTIES_FILE, e.getMessage()));
        }
    }

    protected EtsyRequestManager createRequestManager() {
        EtsyRequestManager requestManager = new EtsyRequestManager(getApiKey(), getApiSecret(), getCallback(), getScope(), System.out);
        final Token accessToken = getAccessToken();

        if (!accessToken.getToken().isEmpty()) {
            BaseTokenStorage tokenStore = new MapStorage();
            tokenStore.putToken("EtsyApiAccessToken", accessToken);
            requestManager.setTokenStorage(tokenStore);
            requestManager.retrieveAccessToken();
        }

        return requestManager;
    }
}
