package correct;

/**
 * @date oct 17, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class MoneySystems {

    static Scanner sc;

    void run() {
        int[] coins = new int[sc.nextInt()];
        int value = sc.nextInt();
        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.println(coinCount(coins, value));
    }

    // O(coins.size()*max)
    long coinCount(int[] coins, int max) {
        long[] out = new long[max+1];
        out[0] = 1;
        for (int c: coins) {
            for (int j = c; j <= max; j++) {
                out[j] += out[j-c];
            }
        }
        return out[max];
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            new MoneySystems().run();
        }
    }
}