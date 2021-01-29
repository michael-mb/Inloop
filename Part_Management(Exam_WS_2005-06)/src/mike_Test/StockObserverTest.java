package mike_Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mike_class.StockObserver;

public class StockObserverTest {
    @Test
    public void testInterface(){
        assertTrue(StockObserver.class.isInterface());
    }
}
