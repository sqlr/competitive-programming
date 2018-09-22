package correct;

/**
 * @date Oct 17, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class RollingDice {

    static Scanner sc;

    void run() {
        char[] moves = sc.nextLine().toCharArray();
        int[] dice   = {1, 2, 3}; // Boven, voor, links
        int[] loc    = {0, 0};
        int steps    = 0;
        boolean inv  = false;
        int tmp, dir;

        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]) {
                case '.':
                    System.out.println("position (" + loc[0] + "," + loc[1] + "), " + dice[0] + " dots");
                case '-':
                    inv = true;
                    break;
                case '+':
                    inv = false;
                    break;
                case 'X':
                    if (steps == 0) steps = 1;
                    movDice(2, steps, inv, dice);
                    loc[0] += (inv ? -1 * steps : steps);
                    steps = 0;
                    break;
                case 'Y':
                    if (steps == 0) steps = 1;
                    movDice(1, steps, inv, dice);
                    loc[1] += (inv ? -1 * steps : steps);
                    steps = 0;
                    break;
                default://digit
                    steps = 10*steps + moves[i] - '0';
                    break;
            }
        }
        return;
    }

    void movDice(int dir, int steps, boolean inv, int[] dice) {
        steps %= 4;
        for (int i = 0; i < steps; i++) {
            if (inv) {
                int tmp   = dice[dir];
                dice[dir] = dice[0];
                dice[0]   = 7 - tmp;
            } else {
                int tmp   = dice[0];
                dice[0]   = dice[dir];
                dice[dir] = 7 - tmp;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            new RollingDice().run();
        }
    }
}