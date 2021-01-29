package mike_test;

import static org.junit.Assert.*;

import org.junit.Test;

import mike_class.Matrix;

public class MatrixTest {
    @Test
    public void testInterface() {
        assertTrue(Matrix.class.isInterface());
    }
}