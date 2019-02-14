package fraction;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
/**
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class Main {

    static final String NUMBER_SPLITTER = "\\s*[+-/\\*]\\s*";
    static final String OPERATOR_SPLITTER = "\\s*\\d+\\s*";

    /**
     * Main of the calculator. Gets user inputs, parses input and creates
     * fractions and invokes the calculation to get a fraction result, which is
     * displayed.
     *
     * @param args
     */
    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        boolean quit = false;
        Fraction result = null;
        while ( !quit ) {
            System.out.print( "Enter your fraction expression: a/b <op> c/d or q to stop: " );
            String line = scanner.nextLine();
            if ( line.toLowerCase().contains( "q" ) ) {
                quit = true;
            } else {
                String[] numbers = line.split( NUMBER_SPLITTER );
                String[] operators = line.split( OPERATOR_SPLITTER );
                int a = parseInt( numbers[ 0 ] );
                int b = parseInt( numbers[ 1 ] );
                int c = parseInt( numbers[ 2 ] );
                int d = parseInt( numbers[ 3 ] );
                Fraction f1 = new Fraction( a, b );
                System.out.println( "f1 = " + f1 );
                Fraction f2 = new Fraction( c, d );
                System.out.println( "f2 = " + f2 );
                String op = operators[ 2 ];
                System.out.println( "op = " + op );
                switch ( op ) {
                    default:
                    case "*":
                        result = f1.multiply( f2 );
                        break;
                    case "/":
                        result = f1.divide( f2 );
                        break;
                    case "+":
                        result = f1.add( f2 );
                        break;
                    case "-":
                        result = f1.subtract( f2 );
                        break;
                }
                System.out.println( "last result = " + result );
            }
        }
    }
}
