package mike_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mike_class.IProject;

public class IProjectTest {
    @Test
    public void testInterface() {
        assertTrue(IProject.class.isInterface());
    }
}
