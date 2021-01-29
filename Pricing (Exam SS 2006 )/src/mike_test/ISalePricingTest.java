package mike_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mike_class.ISalePricing;

public class ISalePricingTest {
    @Test
    public void testInterface() {
        assertTrue(ISalePricing.class.isInterface());
    }
}