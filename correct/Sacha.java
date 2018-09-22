package correct;

/**
 * @date Oct 5, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.* ;

public class Sacha {

    Scanner scanner ;
    String word ;
    String[] dictionary ;
    int[] subs ;
    int minSubs ;

    void detectWord () {
        scanner = new Scanner(System.in) ;

        for (int tc = scanner.nextInt() ; tc > 0 ; tc--) {
            word = scanner.next() ;

            dictionary = new String[scanner.nextInt()] ;
            subs = new int[dictionary.length] ;

            minSubs = -1 ;

            for (int i = 0 ; i < dictionary.length ; i++) {
                dictionary[i] = scanner.next() ;
                subs[i] = 0 ;

                for (int x = 0 ; x < word.length() ; x++) {
                    if (dictionary[i].charAt(x) != word.charAt(x)) {
                        subs[i]++ ;
                    }
                }

                if (subs[i] < minSubs || minSubs == -1) {
                    minSubs = subs[i] ;
                }
            }

            int i = 0 ;
            while (subs[i] != minSubs) {
                i++ ;
            }

            System.out.println(dictionary[i]) ;
        }
    }

    public static void main (String[] args) {
        new Sacha().detectWord() ;
    }
}
