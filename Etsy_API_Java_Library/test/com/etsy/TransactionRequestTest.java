package com.etsy;

import com.etsy.etsyCore.EtsyResult;
import com.etsy.etsyModels.Transaction;
import com.etsy.etsyRequests.TransactionsRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import software.betamax.Configuration;
import software.betamax.junit.Betamax;
import software.betamax.junit.RecorderRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Vladimir Livin, vladimir@livesystems.ru
 */
public class TransactionRequestTest extends EtsyRequestTest {
    @Before
    public void setUp() {
        super.setUp();
    }

    @Rule
    public RecorderRule recorder = new RecorderRule(Configuration.builder().sslEnabled(true).build());

    @Betamax(tape="NewInventoryAPITape")
    @Test
    public void transactionPriceAndShippingCostWithFractionShouldBeReadCorrectly() {
        TransactionsRequest request = TransactionsRequest.getTransaction("1288101195");
        EtsyResult result = requestManager.runRequest(request);

        assertNull(result.getError());
        assertEquals(200, result.getCode());
        assertEquals(1, result.getResults().size());
        Transaction transaction = (Transaction) result.getResults().get(0);
        assertEquals("Price should be 0.5",0.5, transaction.getPrice(), 0.00001);
        assertEquals("Shipping Cost should be 0.2",0.2, transaction.getShippingCost(), 0.00001);
    }
}