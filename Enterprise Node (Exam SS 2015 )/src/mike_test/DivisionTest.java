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

public class DivisionTest {
    private Division division;

    @Before
    public void setUp() {
        division = new Division("Division");
    }

    @Test
    public void testDivisionConsistsOnlyOfTeams() {
        Holding childHolding = new Holding("Holding");
        Company childCompany = new Company("Company");
        Division childDivision = new Division("Division 2");
        Team childTeam = new Team("Team", new StaffMember("Thomas", "Executive"));

        try {
            division.add(null);
            fail("Division.add() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            division.add(childHolding);
            fail("Division.add() should throw an IllegalArgumentException if the argument is a Holding!");
        } catch(IllegalArgumentException e) {
        }

        try {
            division.add(childCompany);
            fail("Division.add() should throw an IllegalArgumentException if the argument is a Company!");
        } catch (IllegalArgumentException e) {
        }

        try {
            division.add(childDivision);
            fail("Division.add() should throw an IllegalArgumentException if the argument is a Division!");
        }  catch (IllegalArgumentException e) {
        }

        assertTrue("Division.add() should return true if a new Team was added!", division.add(childTeam));
        assertFalse("Division.add() should return false if the given Team was already added in the past!",
                division.add(childTeam));
    }
}