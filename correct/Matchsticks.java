package correct;

/**
 * @date Sep 25, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.* ;

public class Matchsticks {

    Scanner scanner ;
    int tc, tcMax ;

    int sticks ;
    String min, max ;

    public void start () {
        scanner = new Scanner(System.in) ;

        for (tc = 0, tcMax = scanner.nextInt() ; tc < tcMax ; tc++) {

            min = max = "" ;
            sticks = scanner.nextInt() ;

            for (int i = 0 ; i < (sticks - (sticks % 2)) / 2 - 1 ; i++) {
                max += "1" ;
            }

            if (sticks % 2 == 0) {
                max += "1" ;
            } else {
                max = "7" + max ;
            }

            if (sticks > 14) {
                sticks -= 14 ;
                
                switch (sticks % 7) {
                    case 1 :
                        min += "108" ;
                        break ;
                    case 2 :
                        min += "188" ;
                        break ;
                    case 3 :
                        min += "200" ;
                        break ;
                    case 4 :
                        min += "208" ;
                        break ;
                    case 5 :
                        min += "288" ;
                        break ;
                    case 6 :
                        min += "688" ;
                        break ;
                    default :
                        min += "88" ;
                        break ;
                }

                for (int i = 0 ; i < sticks / 7 ; i++) {
                    min += "8" ;
                }
            } else {
                switch (sticks) {
                    case 3 :
                        min = "7" ;
                        break ;
                    case 4 :
                        min = "4" ;
                        break ;
                    case 5 :
                        min = "2" ;
                        break ;
                    case 6 :
                        min = "6" ;
                        break ;
                    case 7 :
                        min = "8" ;
                        break ;
                    case 8 :
                        min = "10" ;
                        break ;
                    case 9 :
                        min = "18" ;
                        break ;
                    case 10 :
                        min = "22" ;
                        break ;
                    case 11 :
                        min = "20" ;
                        break ;
                    case 12 :
                        min = "28" ;
                        break ;
                    case 13 :
                        min = "68" ;
                        break ;
                    case 14 :
                        min = "88" ;
                        break ;
                    default :
                        min = "1" ;
                        break ;
                }
            }

            System.out.println(min + " " + max) ;
        }
    }

    public static void main (String[] args) {
        new Matchsticks().start() ;
    }
}