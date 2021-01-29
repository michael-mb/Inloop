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

public class CompanyTest {
    private Company company;

    @Before
    public void setUp() {
        company = new Company("Company");
    }

    @Test
    public void testHoldingConsistsOnlyOfCompanies() {
        Holding childHolding = new Holding("Holding");
        Company childCompany = new Company("Company 2");
        Division childDivision = new Division("Division");
        Team childTeam = new Team("Team", new StaffMember("Thomas", "Executive"));

        try {
            company.add(null);
            fail("Company.add() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            company.add(childHolding);
            fail("Company.add() should throw an IllegalArgumentException if the argument is a Holding!");
        } catch(IllegalArgumentException e) {
        }

        try {
            company.add(childCompany);
            fail("Company.add() should throw an IllegalArgumentException if the argument is a Company!");
        } catch (IllegalArgumentException e) {
        }

        assertTrue("Company.add() should return true if a new Division was added!", company.add(childDivision));
        assertFalse("Company.add() should return false if the given Division was already added in the past!",
                company.add(childDivision));


        try {
            company.add(childTeam);
            fail("Company.add() should throw an IllegalArgumentException if the argument is a Team!");
        } catch (IllegalArgumentException e) {
        }
    }
}
