package correct;

/**
 * @date Sep 26, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.* ;

public class VitosFamily {

    Scanner scanner ;

    int testcases ;
    int n ;
    String[] output ;

    int[] streets ;
    int s ;
    int median ;
    int optimalStreet ;
    int sum = 0 ;

    public void className () {
        scanner = new Scanner(System.in) ;

        testcases = scanner.nextInt() ;

        output = new String[testcases] ;
        
        for (n = 0 ; n < testcases ; n++) {
            streets = new int[scanner.nextInt()] ;

            for (s = 0 ; s < streets.length ; s++) {
                streets[s] = scanner.nextInt() ;
            }

            Arrays.sort(streets) ;

            median = (streets.length - (streets.length % 2)) / 2 ;
            optimalStreet = streets[median] ;
            sum = 0 ;

            for (s = 0 ; s < streets.length ; s++) {
                sum += Math.abs(optimalStreet - streets[s]) ;
            }

            output[n] = "" + sum ;
        }

        for (n = 0 ; n < testcases ; n++) {
            System.out.println(output[n]) ;
        }
    }

    public static void main (String[] args) {
        new VitosFamily().className() ;
    }
}