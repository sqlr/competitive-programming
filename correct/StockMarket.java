package correct;

/**
 * @date Oct 16, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class StockMarket {

    static Scanner sc;

    void run() {
        int balance = 0;
        int change;
        int lowest = 0;
        int lowestDay = 0;
        int bestBuy = 1;
        int bestSell = 1;
        int maxProfit = 0;
        int days = sc.nextInt();

        for (int day = 1; day <= days; day++) {
            change = sc.nextInt();
            balance += change;

            if (balance < lowest) {
                lowest = balance;
                lowestDay = day;
            }
            if (balance - lowest > maxProfit) {
                bestBuy = lowestDay + 1;
                bestSell = day;
                maxProfit = balance - lowest;
            }
        }

        System.out.println(bestBuy + " " + bestSell);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            new StockMarket().run();
        }
    }
}
