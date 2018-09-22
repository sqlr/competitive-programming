package correct;

/**
 * @date Sep 29, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.* ;
import java.text.* ;

public class Gridland {

    Scanner scanner ;
    DecimalFormat pattern ;

    int testcases ;
    int n ;
    double[] output ;

    double cities ;

    public void shortestDistance () {
        scanner = new Scanner(System.in) ;
        pattern = new DecimalFormat("####0.00") ;

        testcases = scanner.nextInt() ;

        output = new double[testcases] ;

        for (n = 0 ; n < testcases ; n++) {
            cities = scanner.nextInt() * scanner.nextInt() ;
            
            if (cities % 2 != 0) {
                cities += 0.41 ;
            }

            output[n] = cities ;
        }

        for (n = 0 ; n < testcases ; n++) {
            System.out.println("Scenario #" + (n + 1) + ":") ;
            System.out.println(pattern.format(output[n])) ;
            System.out.println() ;
        }
    }

    public static void main (String[] args) {
        new Gridland().shortestDistance() ;
    }
}
