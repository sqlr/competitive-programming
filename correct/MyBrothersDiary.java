package correct;

/**
 * @date Oct 16, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class MyBrothersDiary {

    static Scanner sc;

    void run() {
        char[] entry = sc.nextLine().toCharArray();
        int[] occurrences = new int[26];

        for (char c: entry) {
            if (c != ' ') {
                occurrences[(int)(c - 'A')]++;
            }
        }

        int diff = 0;
        int times = 1;

        for (int i = 1; i < 26; i++) {
            if (occurrences[i] == occurrences[diff]) {
                times++;
            } else if (occurrences[i] > occurrences[diff]) {
                diff = i;
                times = 1;
            }
        }

        if (occurrences[diff] == 0 || times != 1) {
            System.out.println("NOT POSSIBLE");
            return;
        }

        diff = (diff + 22) % 26;

        for (int i = 0; i < entry.length; i++) {
            if (entry[i] != ' ') {
                entry[i] = (char) (((entry[i] - 'A' + 26 - diff) % 26) + 'A');
            }
        }

        System.out.println(diff + " " + new String(entry));
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            new MyBrothersDiary().run();
        }
    }
}
