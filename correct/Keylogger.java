package correct;

/**
 * @date Oct 16, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class Keylogger {

    static Scanner sc;

    void run() {
        LinkedList<Character> pass = new LinkedList<Character>();
        char[] log = sc.nextLine().toCharArray();
        int loc = 0;
        for (char c: log) {
            if (c == '<') {
                if (loc > 0) {
                    loc--;
                }
            } else if (c == '>') {
                if (loc < pass.size()) {
                    loc++;
                }
            } else if (c == '-') {
                if (loc != 0) {
                    loc--;
                    pass.remove(loc);
                }
            } else {
                pass.add(loc, c);
                loc++;
            }
        }
        System.out.println(getString(pass));
    }

    String getString(LinkedList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character c: list) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            new Keylogger().run();
        }
    }
}
