package correct;

/**
 * @date Oct 24, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class Pearls {

    static Scanner sc = new Scanner(System.in);

    void run() {
        int[] order    = new int[sc.nextInt()];
        int[] prices   = new int[order.length];
        int[] solution = new int[order.length+1];

        for (int i = 0; i < order.length; i++) {
            order[i]      = sc.nextInt();
            prices[i]     = sc.nextInt();
            solution[i+1] = Integer.MAX_VALUE;
        }

        int min = 0;

        while (min < order.length) {
            for (int sum = 0, i = min; i < order.length; i++) {
                sum += order[i];
                int v = solution[min] + (sum+10)*prices[i];
                if (v < solution[i+1])
                    solution[i+1] = v;
            }
            
            solution[min] = Integer.MAX_VALUE;

            min = 0;
            for (int i = 0; i < solution.length; i++) {
                if (solution[i] < solution[min])
                    min = i;
            }
        }
        System.out.println(solution[order.length]);
    }

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            new Pearls().run();
        }
    }
}
