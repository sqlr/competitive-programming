package correct;

/**
 * @date Sep 25, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.* ;
import java.text.* ;

public class HanselAndGrethel {

    Scanner scanner ;
    DecimalFormat pattern ;

    int testcases ;
    int n ;

    double objOneX, objOneY, objOneD ;
    double objTwoX, objTwoY, objTwoD ;

    int specialX = 0 ;

    double x, y ;

    int decimals = 4 ;

    String[] output ;

    public void calculateLocation () {
        scanner = new Scanner(System.in) ;
        pattern = new DecimalFormat("####0.0000") ;

        testcases = scanner.nextInt() ;
        output = new String[testcases] ;

        for (n = 0 ; n < testcases ; n++) {
            getInput() ;

            if (objOneD == 0.0) {
                x = objOneX ;
                objTwoD = Math.cos(Math.PI * objTwoD / 180)
                        / Math.sin(Math.PI * objTwoD / 180) ;
                y = objTwoD * x + (objTwoY - objTwoD * objTwoX) ;

            } else if (objTwoD == 0.0) {
                x = objTwoX ;
                objOneD = Math.cos(Math.PI * objOneD / 180)
                        / Math.sin(Math.PI * objOneD / 180) ;
                y = objOneD * x + (objOneY - objOneD * objOneX) ;

            } else {
                // Let's change the problem to solving the next problem:
                // y=ax+b && y=px+q
                double a = Math.cos(Math.PI * objOneD / 180)
                        / Math.sin(Math.PI * objOneD / 180) ;
                double b = (objOneY - a * objOneX) ;

                double p = Math.cos(Math.PI * objTwoD / 180)
                        / Math.sin(Math.PI * objTwoD / 180) ;
                double q = (objTwoY - p * objTwoX) ;

                x = (q-b)/(a-p) ;
                y = (p*b-a*q)/(p-a) ;
            }

            output[n] = pattern.format(round(x)) + " "
                    + pattern.format(round(y)) ;
        }

        for (n = 0 ; n < testcases ; n++) {
            System.out.println(output[n]) ;
        }

        return ;
    }

    public void getInput () {
        objOneX = scanner.nextDouble() ;
        objOneY = scanner.nextDouble() ;
        objOneD = scanner.nextDouble() % 180.0 ;

        objTwoX = scanner.nextDouble() ;
        objTwoY = scanner.nextDouble() ;
        objTwoD = scanner.nextDouble() % 180.0 ;
    }

    double round (double d) {
        return Math.round(Math.pow(10, decimals) * d) / Math.pow(10, decimals) ;
    }

    public static void main (String[] args) {
        new HanselAndGrethel().calculateLocation() ;

        return ;
    }
}
