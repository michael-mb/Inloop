package mike_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import mike_class.Flooring;
import mike_class.Surface;

public class FlooringTest {
    private Flooring testFlooring;
    private Surface[] surfaces;
    private int[] results;

    @Before
    public void setUp() {
        surfaces = new Surface[3];
        results = new int[3];

        testFlooring = new Flooring("PVC red", 10.0, 2.0);
        surfaces[0] = new Surface(5.0, 2.0);
        surfaces[0].setMaterial(testFlooring);
        surfaces[1] = new Surface(5.0, 2.808);
        surfaces[1].setMaterial(testFlooring);
        surfaces[2] = new Surface(5.0, 2.804);
        surfaces[2].setMaterial(testFlooring);

        results[0] = 5; // 5.00
        results[1] = 8; // 7.02
        results[2] = 7; // 7.01
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Flooring(null, 10.0, 10.0);
            fail("Flooring.Flooring() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Flooring("", 10.0, 10.0);
            fail("Flooring.Flooring() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Flooring("name", -10.0, 10.0);
            fail("Flooring.Flooring() should throw an IllegalArgumentException if the price argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }


    @Test
    public void testConstructorNonpositiveArgument() {
        try {
            new Flooring("test", 10.0, 0.0);
            fail("The constructor of Flooring should throw an IllegalArgumentException if the width argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Flooring("test", 10.0, -2.0);
            fail("The constructor of Flooring should throw an IllegalArgumentException if the width argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetWidth() {
        assertEquals("Flooring.getWidth() should return the correct value!", 2.0, testFlooring.getWidth(), 0.0);
    }

    @Test
    public void testGetMaterialReqNullArgument() {
        try {
            testFlooring.getMaterialReq(null);
            fail("Flooring.getMaterialReq() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetMaterialReq() {
        assertEquals("Flooring.getMaterialReq() should calculate the required materials using the given formula!",
                results[0], testFlooring.getMaterialReq(surfaces[0]));
        assertEquals("Flooring.getMaterialReq() should round up if the tolerance is higher than or equal to 0.02!",
                results[1], testFlooring.getMaterialReq(surfaces[1]));
        assertEquals("Flooring.getMaterialReq() should round down if the tolerance is less than 0.02!", results[2],
                testFlooring.getMaterialReq(surfaces[2]));
    }
}
