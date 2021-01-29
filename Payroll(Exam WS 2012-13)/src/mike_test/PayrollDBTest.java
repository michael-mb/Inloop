package mike_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mike_class.PayrollDB;

public class PayrollDBTest {
    @Test
    public void testInterface() {
        assertTrue(PayrollDB.class.isInterface());
    }
}
