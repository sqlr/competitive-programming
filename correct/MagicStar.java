package correct;

/**
 * @date Oct 16, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class MagicStar {

    static Scanner sc;
    boolean[] ch = new boolean[12];
    int[] star = new int[12];

    void run() {
        // Input
        String input = sc.nextLine();
        star[0]  = (input.charAt(4) - 'A' + 1) % 56;
        input = sc.nextLine();
        star[1]  = (input.charAt(1) - 'A' + 1) % 56;
        star[2]  = (input.charAt(3) - 'A' + 1) % 56;
        star[3]  = (input.charAt(5) - 'A' + 1) % 56;
        star[4]  = (input.charAt(7) - 'A' + 1) % 56;
        input = sc.nextLine();
        star[5]  = (input.charAt(2) - 'A' + 1) % 56;
        star[6]  = (input.charAt(6) - 'A' + 1) % 56;
        input = sc.nextLine();
        star[7]  = (input.charAt(1) - 'A' + 1) % 56;
        star[8]  = (input.charAt(3) - 'A' + 1) % 56;
        star[9]  = (input.charAt(5) - 'A' + 1) % 56;
        star[10] = (input.charAt(7) - 'A' + 1) % 56;
        input = sc.nextLine();
        star[11] = (input.charAt(4) - 'A' + 1) % 56;

        // Calculating
        for (int i = 0; i < 12; i++) {
            if (star[i] != 0) {
                ch[star[i]-1] = true;
            }
        }

        bruteForce(0);

        // Output
        System.out.println("...." + chr(star[0]) + "....");
        System.out.println("." + chr(star[1]) + "." + chr(star[2]) + "." + chr(star[3]) + "." + chr(star[4]) + ".");
        System.out.println(".." + chr(star[5]) + "..." + chr(star[6]) + "..");
        System.out.println("." + chr(star[7]) + "." + chr(star[8]) + "." + chr(star[9]) + "." + chr(star[10]) + ".");
        System.out.println("...." + chr(star[11]) + "....");
    }

    boolean bruteForce(int depth) {
        if (depth == 12) {
            int test = star[1] + star[2] + star[3] + star[4];
            if (test == star[0] + star[2] + star[5] + star[7]
                    && test == star[0] + star[3] + star[6] + star[10]
                    && test == star[1] + star[5] + star[8] + star[11]
                    && test == star[4] + star[6] + star[9] + star[11]
                    && test == star[7] + star[8] + star[9] + star[10]) {
                return true;
            }
            return false;
        }

        if (star[depth] != 0) {
            return bruteForce(depth + 1);
        }

        for (int i = 0; i < 12; i++) {
            if (ch[i]) {
                continue;
            }
            
            star[depth] = i + 1;
            ch[i] = true;
            if (bruteForce(depth + 1)) {
                return true;
            }
            ch[i] = false;
            star[depth] = 0;
        }
        return false;
    }

    char chr(int c) {
        return (char)(c + 'A' - 1);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        new MagicStar().run();
    }
}