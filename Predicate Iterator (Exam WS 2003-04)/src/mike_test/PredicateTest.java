package mike_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mike_class.Predicate;

public class PredicateTest {
    @Test
    public void testInterface() {
        assertTrue(Predicate.class.isInterface());
    }
}
