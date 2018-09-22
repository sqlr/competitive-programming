package timelimit;

/**
 * @date Oct 16, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class LookAndSaySequences {

    static Scanner sc;

    void run(String x, int i, int j) {
        char ch;
        int num;
        while (i > 0) {
            String old = x;
            x = "";
            ch = old.charAt(0);
            num = 1;
            for (int n = 1; n < old.length(); n++) {
                if (old.charAt(n) == ch) {
                    num++;
                } else {
                    x += num + "" + ch;
                    ch = old.charAt(n);
                    num = 1;
                }
            }
            x += num + "" + ch;
            i--;
        }
        System.out.println(x.charAt(j));
    }

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(new FileReader("lookandsay.in"));
        int c = 0;
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            int i = sc.nextInt();
            int j = sc.nextInt();

            if (x == 0 && i == 0 && j == 0) {
                return;
            }
            System.out.print(++c + ": ");
            new LookAndSaySequences().run(Integer.toString(x), i-1, j-1);
        }
    }
}