package correct;

/**
 * @date Oct 6, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.* ;

public class AnIndustrialSpy {

    static Scanner scanner ;
    
    final static int maxpriem = 10000000 ;
    final static byte[] a = new byte[maxpriem] ;

    void run () {

        HashSet<Integer> priemen = new HashSet<Integer>() ;

        String word = scanner.next() ;

        int n = Integer.parseInt(word) ;
        n = n * ((int) Math.pow(10, word.length() - ((int) Math.log10(n)) - 1));

        ArrayList<Integer> x = new ArrayList<Integer>() ;

        while (n != 0) {
            x.add(n % 10) ;
            n /= 10 ;
        }

        Collections.sort(x) ;

        do {
            int p = 0 ;
            int m = 1 ;
            for (int i = 0 ; i < x.size() ; i++) {
                p += x.get(i) * m ;
                m *= 10 ;
            }

            while (p != 0) {
                if (a[p] == 0) {
                    priemen.add(p) ;
                }

                p /= 10 ;
            }

        } while (next_permutation(x)) ;

        System.out.println(priemen.size()) ;
    }

    public boolean next_permutation (ArrayList<Integer> b) {
        for (int i = b.size() - 2, j ; i >= 0 ; i--) {
            if (b.get(i + 1) > b.get(i)) {
                for (j = b.size() - 1 ; b.get(j) <= b.get(i) ; j--) {}

                Collections.swap(b, i, j) ;

                for (j = 1 ; j <= (b.size() - i) / 2 ; j++) {
                    Collections.swap(b, i + j, b.size() - j) ;
                }
                return true ;
            }
        }
        return false ;
    }

    void erastosthenes () {
        a[0] = a[1] = 1 ;
        int p = 2 ;
        int j ;

        while (true) {
            j = p * p ;
            
            if (j > maxpriem) {
                break ;
            }
            
            while (j < maxpriem) {
                a[j] = 1 ;
                j += p ;
            }

            do {
                p++ ;
            } while (a[p] == 1 && p < maxpriem - 1) ;
        }
    }

    public static void main (String[] args) {
        scanner = new Scanner(System.in) ;

        new AnIndustrialSpy().erastosthenes() ;
        
        for (int i = scanner.nextInt() ; i > 0 ; i--) {
            new AnIndustrialSpy().run() ;
        }
    }
}
