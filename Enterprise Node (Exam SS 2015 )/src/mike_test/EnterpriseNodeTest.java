package mike_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mike_class.EnterpriseNode;

public class EnterpriseNodeTest {
    @Test
    public void testInterface() {
        assertTrue(EnterpriseNode.class.isInterface());
    }
}
