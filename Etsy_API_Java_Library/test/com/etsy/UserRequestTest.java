package com.etsy;

import com.etsy.etsyCore.EtsyResult;
import com.etsy.etsyModels.BaseModel;
import com.etsy.etsyModels.Shop;
import com.etsy.etsyModels.User;
import com.etsy.etsyRequests.ShopsRequest;
import com.etsy.etsyRequests.UsersRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import software.betamax.Configuration;
import software.betamax.TapeMode;
import software.betamax.junit.Betamax;
import software.betamax.junit.RecorderRule;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests UserRequest and related data.
 *
 * @author Vladimir Livin, vladimir@livesystems.ru
 */
public class UserRequestTest extends EtsyRequestTest {
    @Before
    public void setUp() {
        super.setUp();
    }

    @Rule public RecorderRule recorder = new RecorderRule(Configuration.builder().sslEnabled(true).build());

    @Betamax(tape="NewInventoryAPITape")
    @Test
    public void userThatNotOptedOutShouldHaveNewInventoryEndpointsEnabled(){
        EtsyResult result = requestManager.runRequest(UsersRequest.getUser("trueship"));
        List<BaseModel> modelList = result.getResults();
        final User user = (User) modelList.get(0);
        assertEquals("trueship", user.getLoginName());
        assertTrue("User that is not opted-out should have new_inventory_endpoints enabled", user.isUseNewInventoryEndpoints());
    }

    @Betamax(tape="NewInventoryAPITape")
    @Test
    public void userThatOptedOutShouldHaveNewInventoryEndpointsDisabled(){
        EtsyResult result = requestManager.runRequest(UsersRequest.getUser("trueship-optedout"));
        List<BaseModel> modelList = result.getResults();
        final User user = (User) modelList.get(0);
        assertFalse("User that is opted-out should have new_inventory_endpoints disabled", user.isUseNewInventoryEndpoints());
    }
}
