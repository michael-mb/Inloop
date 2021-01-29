package mike_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import mike_class.Company;
import mike_class.Division;
import mike_class.Holding;
import mike_class.StaffMember;
import mike_class.Team;

public class HoldingTest {
    private Holding holding;

    @Before
    public void setUp() {
        holding = new Holding("Holding");
    }

    @Test
    public void testHoldingConsistsOnlyOfCompanies() {
        Holding childHolding = new Holding("Holding 2");
        Company childCompany = new Company("Company");
        Division childDivision = new Division("Division");
        Team childTeam = new Team("Team", new StaffMember("Thomas", "Executive"));

        try {
            holding.add(null);
            fail("Holding.add() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            holding.add(childHolding);
            fail("Holding.add() should throw an IllegalArgumentException if the argument is a Holding!");
        } catch(IllegalArgumentException e) {
        }

        assertTrue("Holding.add() should return true if a new Company was added!", holding.add(childCompany));
        assertFalse("Holding.add() should return false if the given Company was already added in the past!",
                holding.add(childCompany));

        try {
            holding.add(childDivision);
            fail("Holding.add() should throw an IllegalArgumentException if the argument is a Division!");
        } catch (IllegalArgumentException e) {
        }

        try {
            holding.add(childTeam);
            fail("Holding.add() should throw an IllegalArgumentException if the argument is a Team!");
        } catch (IllegalArgumentException e) {
        }
    }
}
