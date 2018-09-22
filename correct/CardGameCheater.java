package correct;

/**
 * @date Oct 16, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class CardGameCheater {

    static Scanner sc;

    void run() {
        int[][]  cards = new int[2][Integer.parseInt(sc.nextLine())];
        String[] input = new String[2];

        input[0] = sc.nextLine();
        input[1] = sc.nextLine();

        char cValue, cSuit;
        for (int p = 0; p < 2; p++) {
            for (int c = 0; c < cards[0].length; c++) {
                cValue = input[p].charAt(3*c);
                cSuit  = input[p].charAt(3*c+1);
                
                if      (cValue == 'T') cards[p][c] = 100;
                else if (cValue == 'J') cards[p][c] = 110;
                else if (cValue == 'Q') cards[p][c] = 120;
                else if (cValue == 'K') cards[p][c] = 130;
                else if (cValue == 'A') cards[p][c] = 140;
                else                    cards[p][c] = 10 * (cValue - '0');
                
                if      (cSuit == 'D') cards[p][c] += 1;
                else if (cSuit == 'S') cards[p][c] += 2;
                else if (cSuit == 'H') cards[p][c] += 3;
            }
        }

        Arrays.sort(cards[0]);
        Arrays.sort(cards[1]);

        int points = 0;

        for (int a = cards[0].length - 1, e = cards[1].length - 1; a >= 0; a--) {
            if (cards[1][e] > cards[0][a]) {
                points++;
                e--;
            }
        }

        System.out.println(points);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            new CardGameCheater().run();
        }
    }
}