package mike_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import mike_class.BankAccount;

public class ClosedTest {

    private BankAccount account;
    private static final double DELTA = 0.001;

    @Before
    public void setUp() {
        account = new BankAccount("12345", 10);
        account.close();
    }

    @Test
    public void testClosedInheritance() {
        var frozenClass = Arrays.stream(BankAccount.class.getDeclaredClasses())
                .filter(cls -> cls.getSimpleName().equals("Closed"))
                .findFirst();

        if (frozenClass.isPresent()) {
            assertEquals(
                    "Closed should be subclass of AccountState",
                    "AccountState",
                    frozenClass.get().getSuperclass().getSimpleName()
            );
        } else {
            fail("BankAccount should have inner class Closed");
        }
    }

    @Test
    public void testToString() {
        assertEquals(
                "BankAccount.getState() should return \"Closed\", if the state is Closed.",
                "Closed",
                account.getState()
        );
    }

    @Test
    public void testPayIn() {
        try {
            account.payIn(10);
            fail("Closed.payIn() should throw an IllegalStateException.");
        } catch (IllegalStateException ignored) {
        }
        assertEquals(
                "Closed.payIn() should not change the account's balance",
                0.0,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Closed.payIn() should not change the account's state",
                "Closed",
                account.getState()
        );
    }

    @Test
    public void testPayOff() {
        try {
            account.payOff(10);
            fail("Closed.payOff() should throw an IllegalStateException.");
        } catch (IllegalStateException ignored) {
        }
        assertEquals(
                "Closed.payOff() should not change the account's balance",
                0.0,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Closed.payOff() should not change the account's state",
                "Closed",
                account.getState()
        );
    }

    @Test
    public void testPayInterest() {
        try {
            account.payInterest();
            fail("Closed.payInterest() should throw an IllegalStateException.");
        } catch (IllegalStateException ignored) {
        }
        assertEquals(
                "Closed.payInterest() should not change the account's balance",
                0.0,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Closed.payInterest() should not change the account's state",
                "Closed",
                account.getState()
        );

    }

    @Test
    public void testPrintBalance() {
        var outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        account.printBalance();
        var outString = outStream.toString(StandardCharsets.UTF_8);
        assertEquals(
                "Closed.printBalance() should print the balance as specified in the task description.",
                "This account is CLOSED. The balance is 0.",
                outString.trim()
        );
    }
}
