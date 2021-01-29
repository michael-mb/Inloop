package mike_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mike_class.EnterpriseNodeIterator;

public class EnterpriseNodeIteratorTest {
    @Test
    public void testInterface() {
        assertTrue(EnterpriseNodeIterator.class.isInterface());
    }
}