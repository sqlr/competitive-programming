package correct;

/**
 * @date Oct 16, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class BurgerTime {

    static Scanner sc;

    void run(int length) {
        String line = sc.nextLine();
        
        int lastRestaurant = -1;
        int lastDrugstore = -1;
        int shortest = Integer.MAX_VALUE;
        int distance;

        for (int i = 0; i < length; i++) {
            char c = line.charAt(i);
            if (c == 'R') {
                lastRestaurant = i;
                distance = lastRestaurant - lastDrugstore;
                if (lastDrugstore != -1 && distance < shortest) {
                    shortest = distance;
                }
            }
            if (c == 'D') {
                lastDrugstore = i;
                distance = lastDrugstore - lastRestaurant;
                if (lastRestaurant != -1 && distance < shortest) {
                    shortest = distance;
                }
            }
            if (c == 'Z') {
                System.out.println("0");
                return;
            }
        }

        System.out.println("" + shortest);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int length;
        while (true) {
            length = Integer.parseInt(sc.nextLine());
            if (length == 0) {
                return;
            }
            new BurgerTime().run(length);
        }
    }
}
