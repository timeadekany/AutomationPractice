package timeadekany.fibonacci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FiconacciTest {

    Fibonacci victim = new Fibonacci();

    @Test
    public void testFibonacci() {
        assertEquals(1, victim.calculate(1));
        assertEquals(1, victim.calculate(2));
        assertEquals(2, victim.calculate(3));
        assertEquals(3, victim.calculate(4));
        assertEquals(5, victim.calculate(5));
    }

    @Test
    public void testNonValidArguments() {
        assertEquals(0, victim.calculate(0));
        assertEquals(0, victim.calculate(-1));
        assertEquals(0, victim.calculate(250_000));
    }
}
