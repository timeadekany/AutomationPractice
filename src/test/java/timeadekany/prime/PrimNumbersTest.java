package timeadekany.prime;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimNumbersTest {

    @Test
    public void testPrim() {
        PrimExaminator primExaminator = new PrimExaminator();
        assertTrue(primExaminator.calculateClosestPrime(2).isTheNumberPrime());
        assertTrue(primExaminator.calculateClosestPrime(3).isTheNumberPrime());
        assertTrue(primExaminator.calculateClosestPrime(7).isTheNumberPrime());
        assertFalse(primExaminator.calculateClosestPrime(21).isTheNumberPrime());
        assertFalse(primExaminator.calculateClosestPrime(100).isTheNumberPrime());
        assertTrue(primExaminator.calculateClosestPrime(1021).isTheNumberPrime());
    }

    @Test
    public void testNonValidArguments() {
        PrimExaminator primExaminator = new PrimExaminator();
        assertFalse(primExaminator.calculateClosestPrime(-1).isTheNumberPrime());
        assertFalse(primExaminator.calculateClosestPrime(0).isTheNumberPrime());
        assertFalse(primExaminator.calculateClosestPrime(1).isTheNumberPrime());
    }
}
