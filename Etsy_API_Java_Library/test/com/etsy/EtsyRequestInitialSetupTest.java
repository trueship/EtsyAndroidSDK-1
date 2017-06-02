package com.etsy;

import com.etsy.etsyCore.BaseTokenStorage;
import com.etsy.etsyCore.EtsyRequestManager;
import com.etsy.etsyCore.MapStorage;
import org.junit.Before;
import org.junit.Test;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;

/**
 * This setup should be run once to get the request token
 * which can be later used for test against real etsy.
 *
 * Usage:
 *  1. Run step1RequestAuthUrl
 *  2. Authenticate the app by visiting URL and copy verification auth code to authCode property.
 *  3. Run step2CompleteAuthAndSaveAccessToken
 *
 * @author Vladimir Livin, vladimir@livesystems.ru
 */
public class EtsyRequestInitialSetupTest extends EtsyRequestTest {
    private final static Logger log = Logger.getLogger(EtsyRequestInitialSetupTest.class.getName());

    @Before
    public void setUp() {
        super.setUp();
    }

    public String getAuthCode() {
        return getProperties().getProperty("authCode", "");
    }

    public Token getRequestToken() {
        return new Token(getProperties().getProperty("requestToken.token", ""), getProperties().getProperty("requestToken.secret", ""));
    }

    @Test
    public void step1RequestAuthUrl() throws IOException {
        assertFalse("apiKey should be not empty set", getApiKey().isEmpty());
        assertFalse("apiSecret should be not empty set", getApiSecret().isEmpty());
        System.out.println("Please authenticate at following URL: " + getAuthUrl());
    }

    @Test
    public void step2CompleteAuthAndSaveAccessToken() throws IOException {
        assertFalse("authCode should be not empty set - copy it from the auth page", getAuthCode().isEmpty());
        assertFalse("requestToken.token should be not empty", getRequestToken().getToken().isEmpty());
        assertFalse("requestToken.access should be not empty", getRequestToken().getSecret().isEmpty());

        EtsyRequestManager requestManager = createRequestManager();
        BaseTokenStorage tokenStore = new MapStorage();
        requestManager.setRequestToken(getRequestToken());

        try {
            requestManager.finishAuthentication(getAuthCode(), tokenStore);
        } catch (OAuthException e) {
            if (e.getMessage().contains("Request token has expired")) {
                log.warning("The token you've tried to use is no longer working or expired. Re-requesting authentication...");
                step1RequestAuthUrl();
                return;
            }
        }
        Token savedToken = tokenStore.getToken("EtsyApiAccessToken");
        System.out.println("Access token " + savedToken + " saved to " + TEST_PROPERTIES_FILE + ". Well done!");
        getProperties().setProperty("accessToken.token", savedToken.getToken());
        getProperties().setProperty("accessToken.secret", savedToken.getSecret());
        saveProperties();
    }

    private void saveProperties() throws IOException {
        getProperties().store(new FileWriter(TEST_PROPERTIES_FILE), null);
    }


    private String getAuthUrl() throws IOException {
        EtsyRequestManager requestManager = createRequestManager();
        String url = requestManager.startAuthentication();

        getProperties().setProperty("requestToken.token", requestManager.getRequestToken().getToken());
        getProperties().setProperty("requestToken.secret", requestManager.getRequestToken().getSecret());
        saveProperties();
        System.out.println("Request token saved.");

        return url;
    }
}
