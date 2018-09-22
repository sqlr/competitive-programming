package correct;

/**
 * @date Oct 5, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.* ;

public class HaveANiceDay {

    Scanner scanner ;
    int tc ;

    int day ;
    int month ;
    int year ;
    int yPart1, yPart2 ;

    void parse () {
        scanner = new Scanner(System.in) ;

        for (tc = scanner.nextInt() ; tc > 0 ; tc--) {
            day = scanner.nextInt() ;
            month = scanner.nextInt() ;
            year = scanner.nextInt() ;
            yPart2 = year % 100 ;
            yPart1 = (year - yPart2) / 100 ;

            if (equalOccurence() &&
                    ( day == month + yPart1 + yPart2
                    || month == day + yPart1 + yPart2
                    || yPart1 == day + month + yPart2
                    || yPart2 == day + month + yPart1
                    || day + month == yPart1 + yPart2
                    || day + yPart1 == month + yPart2
                    || day + yPart2 == month + yPart1)) {
                System.out.println("yes") ;
            } else {
                System.out.println("no") ;
            }
        }
    }

    boolean equalOccurence () {
        int occurences = 0 ;

        int[] count = new int[10] ;

        if (day > 9) {
            count[nthdigit(day, 1)]++ ;
        }
        count[nthdigit(day, 0)]++ ;

        if (month > 9) {
            count[nthdigit(month, 1)]++ ;
        }
        count[nthdigit(month, 0)]++ ;

        count[nthdigit(year, 3)]++ ;
        count[nthdigit(year, 2)]++ ;
        count[nthdigit(year, 1)]++ ;
        count[nthdigit(year, 0)]++ ;

        for (int i = 0 ; i < count.length ; i++) {
            if (count[i] != 0 && count[i] != occurences) {
                if (occurences == 0) {
                    occurences = count[i] ;
                } else {
                    return false ;
                }
            }
        }

        return true ;
    }

    int nthdigit (int x, int n) {
        while (n-- != 0) {
            x /= 10 ;
        }
        return (x % 10) ;
    }

    public static void main (String[] args) {
        new HaveANiceDay().parse() ;
    }
}
