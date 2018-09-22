package correct;

/**
 * @date Oct 16, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class DividingTheLoot {

    static Scanner sc;

    void run() {
        int pirates = sc.nextInt();
        int numLoot = sc.nextInt();
        int loot = 0;

        if (pirates >= numLoot) {
            for (int i = 0; i < numLoot; i++) {
                sc.nextInt();
            }
            System.out.println("0");
            return;
        }

        if (pirates == 0) {
            for (int i = 0; i < numLoot; i++) {
                loot += sc.nextInt();
            }
            System.out.println(loot);
            return;
        }

        int keep = numLoot / (pirates + 1);
        PriorityQueue<Integer> captainsShare = new PriorityQueue<Integer>();

        for (int i = 0; i < numLoot; i++) {
            int v = sc.nextInt();
            if (captainsShare.size() < keep) {
                captainsShare.add(v);
                continue;
            }
            if (v > captainsShare.peek()) {
                captainsShare.poll();
                captainsShare.add(v);
            }
        }

        while (!captainsShare.isEmpty()) {
            loot += captainsShare.poll();
        }
        System.out.println(loot);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            new DividingTheLoot().run();
        }
    }
}
