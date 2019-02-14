package fraction;

/**
 * Immutable fraction which is always in simplified or normal form. Simplified
 * or Normal form means that the greatest common divisor of numerator and
 * denominator is one. This is achieved by normalising the input parameters
 * before they are stored in the appropriate fields.
 * <p>
 * Note to the implementor: by separating the common part of
 * multiplication/division and addition/subtraction into separate methods, these
 * extra methods can do the "heavy lifting" of the computation. For instance,
 * because addition and subtraction are basically the same operation, using the
 * <code>add(int, int)</code> method in both cases with a negative numerator in
 * the subtract case, the (somewhat) complex add method does the work for both.
 * This also avoids producing intermediate fractions in the computation,
 * avoiding waste (garbage to be collected) thereby keeping the world a cleaner
 * place. At least the garbage collector has less work ☺.
 * <p>
 * For this exercise you may assume that the denominator passed in is never 0.
 * This is assured by a argument test in the only constructor in this class.
 *
 * @author hvd
 * @author hom
 */
public class Fraction {

    /**
     * Constructor for objects of class Fraction. TASK_1A. Initialize the
     * attributes so that a possible negative sign for the denominator will be
     * converted into a switch of the sign for the numerator. The fraction
     * should be simplified, using the existing {@code gcd()} method. (Both
     * numerator and denominator must be divided by the gcd).
     * <p>
     * Examples:
     * <ul><li>the fraction (2/-3) will be initialized as (-2/3).</li>
     * <li>the fraction (-2/-3) will be initialized as (2/3)</li>
     * <li>the fraction (-3/12) will be initialized as (-1/4)</li>
     * </ul>
     *
     * @param aNumerator value for numerator
     * @param aDenominator value for denominator. Checked to ensure it is not 0.
     */
    
    private int numerator;
    private int denominator;
    
    
    Fraction(int aNumerator, int aDenominator) {
        this.denominator = aDenominator;
        this.numerator = aNumerator;
        
        if(denominator<0){
            denominator = -denominator;
            numerator = -numerator;
        }
        
        int g = gcd(numerator, denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
    
    /**
     * Determine Greatest Common Divisor. e.g. 3/12 has 3 as gcd.
     *
     * @param a parameter 1
     * @param b parameter 2
     *
     * @return the greatest int that divides both a and b evenly (without rest).
     * Minimum value is 1.
     */
    static int gcd( int a, int b ) {
        // ensure loop uses positive values
        a = Math.abs( a );
        b = Math.abs( b );
        while ( b != 0 ) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    


    public Fraction multiply(Fraction f1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Fraction multiply(Fraction f1, Fraction f2) {
        int numeratorResult = f1.getNumerator() * f2.getNumerator();
        int denominatorResult = f1.getDenominator() * f2.getDenominator();
        return new Fraction(numeratorResult, denominatorResult);
    }

    public Fraction divide(Fraction f1, Fraction f2) {
        Fraction reverseFractionB = new Fraction(f2.getDenominator(), f2.getNumerator());

        return multiply(f1, reverseFractionB);
    }
    
    public Fraction divide(Fraction f1) {
        Fraction reverseFractionB = new Fraction(f1.getDenominator(), f1.getNumerator());
        return multiply(this, reverseFractionB);
    }

    public Fraction add(Fraction f1, Fraction f2) {
        int numeratorResult = (
                f1.getNumerator() * f2.getDenominator() 
                + f2.getNumerator() * f1.getDenominator());
        int denominatorResult = f1.getDenominator() * f1.getDenominator();

        return new Fraction(numeratorResult, denominatorResult);
    }
    
    public Fraction add(Fraction f1) {
        int numeratorResult = (numerator * f1.getDenominator() + f1.getNumerator() * denominator);
        int denominatorResult = denominator * numerator;

        return new Fraction(numeratorResult, denominatorResult);
    }

    public Fraction subtract(Fraction f1, Fraction f2) {
       int negativNumerator = -f2.getNumerator();
        Fraction negatedFractionB = new Fraction(negativNumerator, f2.getDenominator());

        return add(f1, negatedFractionB);
    }
    
    public Fraction subtract(Fraction f1) {
       int negativNumerator = -f1.getNumerator();
       
       Fraction negatedFractionB = new Fraction(negativNumerator, f1.getDenominator());

        return add(this, negatedFractionB);
    }

    @Override
    public String toString() {
        return "(" + numerator + "/" + denominator + ")";
    }

    
    
}
