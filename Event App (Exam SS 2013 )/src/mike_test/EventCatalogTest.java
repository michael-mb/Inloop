package mike_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mike_class.EventCatalog;

public class EventCatalogTest {
    @Test
    public void testInterface() {
        assertTrue(EventCatalog.class.isInterface());
    }
}
