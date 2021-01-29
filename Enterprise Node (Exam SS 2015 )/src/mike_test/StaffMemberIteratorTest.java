package mike_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Test;

import mike_class.StaffMember;
import mike_class.StaffMemberIterator;

public class StaffMemberIteratorTest {
    @Test
    public void testConstructorNullArgument() {
        try {
            new StaffMemberIterator(null);
            fail("StaffMemberIterator.StaffMemberIterator() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testIteratorNullInSet() {
        Set<StaffMember> nullSet = new HashSet<>();
        nullSet.add(null);

        try{
            new StaffMemberIterator(nullSet);
            fail("StaffMemberIterator.StaffMemberIterator() should throw a NullPointerException if the argument contains null!");
        }
        catch (NullPointerException e) {
        }
    }

    @Test
    public void testIteratorEmptySet() {
        Iterator<StaffMember> iter = new StaffMemberIterator(new HashSet<>());

        assertFalse("StaffMemberIterator.hasNext() should return false if there is no next element!", iter.hasNext());
        try {
            iter.next();
            fail("StaffMemberIterator.next() should throw a NoSuchElementException if there is no next element!");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void testIterator() {
        StaffMember teamLeader = new StaffMember("Mike", "Supervisor");
        List<StaffMember> expectedMembers = new ArrayList<>(TeamTest.createTeamHierarchy(teamLeader));
        expectedMembers.remove(teamLeader);
        Iterator<StaffMember> expectedIter = expectedMembers.iterator();
        Iterator<StaffMember> actualIter = new StaffMemberIterator(teamLeader.getDirectSubordinates());

        while (expectedIter.hasNext()) {
            assertTrue("StaffMemberIterator.hasNext() should return true if there is a next available element!",
                    actualIter.hasNext());
            assertEquals(
                    "StaffMemberIterator.next() should return the correct next element if there is one available!",
                    expectedIter.next(), actualIter.next());
        }

        assertFalse("StaffMemberIterator.hasNext() should return false if there is no next element!",
                actualIter.hasNext());
        try {
            actualIter.next();
            fail("StaffMemberIterator.next() should throw a NoSuchElementException if there is no next element!");
        } catch (NoSuchElementException e) {
        }
    }
}
