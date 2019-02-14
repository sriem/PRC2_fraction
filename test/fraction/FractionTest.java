package fraction;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Fraction. To the implementor: use toString in one set of tests
 * and the getters for numerator and denominator in another test.
 *
 * @author hvd
 */
public class FractionTest {

    /**
     * TASK_1B: Test toString. Make test with one assertion for each case.
     * <br> Implement test method to verify if the output of a
     * <br> Fraction is in the required form:
     * <br> 2/3 should be represented as "(2/3)"
     * <br> -2/3 should be represented as "(-2/3)"
     * <br> 2/-3 should be represented as "(-2/3)"
     * <br> -2/-3 should be represented as "(2/3)"
     * <br> 4/12 should be represented as "(1/3)"
     */
    @Test
    public void testToString23() {
        Fraction f23 = new Fraction( 2, 3 );
        assertEquals( "Result should be", "(2/3)", f23.toString() );
    }
    @Test
    public void testToStringm23() {
        Fraction f23 = new Fraction( 2, -3 );
        assertEquals( "Result should be", "(-2/3)", f23.toString() );
    }
    @Test
    public void testToStringMinus23() {
        Fraction fm23 = new Fraction( -2, 3 );
        assertEquals( "Result should be", "(-2/3)", fm23.toString() );
    }
    @Test
    public void testToString2Minus3() {
        Fraction f2m3 = new Fraction( 2, -3 );
        assertEquals( "Result should be", "(-2/3)", f2m3.toString() );
    }
    @Test
    public void testToStringMinus2Minus3() {
        Fraction fm2m3 = new Fraction( -2, -3 );
        assertEquals( "Result should be", "(2/3)", fm2m3.toString() );
    }
    @Test
    public void testToString412to13() {
        Fraction f412to13 = new Fraction( 4, 12 );
        assertEquals( "Result should be", "(1/3)", f412to13.toString() );
    }
    @Test
    
    public void testFractionMultiply() {
        Fraction fractionA = new Fraction( 8, 4);
        Fraction fractionB = new Fraction( 5, 3);
        assertEquals( "Result should be", "(10/3)", fractionA.multiply(fractionA, fractionB).toString() );
    }
    @Test
    public void testFractionAdd() {
        Fraction fractionA = new Fraction( 2, 8);
        Fraction fractionB = new Fraction( 4, 16);
        assertEquals( "Result should be", "(1/2)", fractionA.add(fractionA, fractionB).toString() );
    }
    @Test
    public void testFractionSubtract() {
        Fraction fractionA = new Fraction( 8, 10);
        Fraction fractionB = new Fraction( 6, 30);
        assertEquals( "Result should be", "(3/5)", fractionA.subtract(fractionA, fractionB).toString() );
    }
    @Test
    public void testFractionDevide() {
        Fraction fractionA = new Fraction( 5, 9);
        Fraction fractionB = new Fraction( 7, 9);
        assertEquals( "Result should be", "(5/7)", fractionA.divide(fractionA, fractionB).toString() );
    }
  


}
