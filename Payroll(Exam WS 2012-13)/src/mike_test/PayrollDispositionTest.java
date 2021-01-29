package mike_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mike_class.PayrollDisposition;

public class PayrollDispositionTest {
    @Test
    public void testInterface() {
        assertTrue(PayrollDisposition.class.isInterface());
    }
}