package com.etsy;

import com.etsy.etsyCore.EtsyResult;
import com.etsy.etsyModels.Shop;
import com.etsy.etsyRequests.ShopsRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import software.betamax.Configuration;
import software.betamax.TapeMode;
import software.betamax.junit.Betamax;
import software.betamax.junit.RecorderRule;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Tests ShopRequest and related data.
 *
 * @author Vladimir Livin, vladimir@livesystems.ru
 */
public class ShopRequestTest extends EtsyRequestTest {
    @Before
    public void setUp() {
        super.setUp();
    }

    @Rule
    public RecorderRule recorder = new RecorderRule(Configuration.builder().sslEnabled(true).build());

    @Betamax(tape="NewInventoryAPITape")
    @Test
    public void shopShouldntBeOptedOutFromUsingNewAPIInventoryEndpoints() {
        EtsyResult result = requestManager.runRequest(ShopsRequest.getShop("8093085"));
        assertEquals("One shop should be found",1, result.getResults().size());
        Shop shop = (Shop) result.getResults().get(0);
        assertEquals("DemoRSShop", shop.getShopName());
        assertTrue("Shop shouldn't be opted-out from using of a new Inventory API Endpoints", shop.isUseNewInventoryEndpoints());
    }
}
