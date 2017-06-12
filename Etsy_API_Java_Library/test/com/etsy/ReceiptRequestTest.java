package com.etsy;

import com.etsy.etsyCore.EtsyResult;
import com.etsy.etsyModels.Receipt;
import com.etsy.etsyModels.Transaction;
import com.etsy.etsyRequests.ReceiptsRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import software.betamax.Configuration;
import software.betamax.junit.Betamax;
import software.betamax.junit.RecorderRule;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Vladimir Livin, vladimir@livesystems.ru
 */
public class ReceiptRequestTest extends EtsyRequestTest {
    @Before
    public void setUp() {
        super.setUp();
    }

    @Rule
    public RecorderRule recorder = new RecorderRule(Configuration.builder().sslEnabled(true).build());

    @Betamax(tape="NewInventoryAPITape")
    @Test
    public void receiptWithDifferentOfferingsShouldHaveCorrectTransactionPrice() {
        ReceiptsRequest request = ReceiptsRequest.getReceipt("1197623530");
        Map<String, String> params = new HashMap<>();
        params.put("includes", "Listings,Transactions,Transactions/Listing,Buyer/Addresses,Buyer/Country,Order,Coupon");
        request.addParams(params);
        EtsyResult result = requestManager.runRequest(request);

        assertNull(result.getError());
        assertEquals(200, result.getCode());
        assertEquals(1, result.getResults().size());
        Receipt receipt = (Receipt) result.getResults().get(0);
        assertEquals("Receipt should have 1 transaction", 1, receipt.getTransactions().length);
        Transaction transaction = receipt.getTransactions()[0];
        assertEquals("Price should be 1 USD and represent single item price", 1.0, transaction.getPrice(), 0.00001);
        assertEquals("Currency should be USD", "USD", transaction.getCurrencyCode());
        assertEquals(1, transaction.getQuantity());
    }

    @Betamax(tape="NewInventoryAPITape")
    @Test
    public void receiptCreatedWithOldVariationsShouldHaveCorrectTransactionPrice() {
        ReceiptsRequest request = ReceiptsRequest.getReceipt("98232671");
        Map<String, String> params = new HashMap<>();
        params.put("includes", "Listings,Transactions,Transactions/Listing,Buyer/Addresses,Buyer/Country,Order,Coupon");
        request.addParams(params);
        EtsyResult result = requestManager.runRequest(request);

        assertNull(result.getError());
        assertEquals(200, result.getCode());
        assertEquals(1, result.getResults().size());
        Receipt receipt = (Receipt) result.getResults().get(0);
        assertEquals("Receipt should have 1 transaction", 1, receipt.getTransactions().length);
        Transaction transaction = receipt.getTransactions()[0];
        assertEquals("Price should be 1 USD and represent single item price", 1.0, transaction.getPrice(), 0.00001);
        assertEquals("Currency should be USD", "USD", transaction.getCurrencyCode());
        assertEquals(3, transaction.getQuantity());
    }


    @Betamax(tape="NewInventoryAPITape")
    @Test
    public void receiptWithUserWithoutFeedbackInfoShouldNotCrash() {
        ReceiptsRequest request = ReceiptsRequest.getReceipt("1201560310");
        Map<String, String> params = new HashMap<>();
        params.put("includes", "Listings,Transactions,Transactions/Listing,Buyer/Addresses,Buyer/Country,Order,Coupon");
        request.addParams(params);
        EtsyResult result = requestManager.runRequest(request);

        assertNull(result.getError());
        assertEquals(200, result.getCode());
        Receipt receipt = (Receipt) result.getResults().get(0);
        assertNull("This buyer should have no feedback info attached", receipt.getBuyer().getFeedbackInfo());
    }
}
