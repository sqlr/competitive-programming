package correct;

import java.util.*;

public class BeerPrices {
    static Scanner sc = new Scanner(System.in);
    void run() {
        int dist[] = new int[sc.nextInt()], price[] = new int[dist.length], trunk = sc.nextInt(), profit = 0, beer = 0, diff;
        for (int i = 1; i < dist.length; i++) {
            dist[i] = sc.nextInt();
            if (dist[i] > trunk) {
                System.out.println("impossible");
                sc.nextLine();
                sc.nextLine();
                return;
            }
        }
        price[0] = sc.nextInt();
        for (int i = 1; i < price.length; i++) {
            price[i] = sc.nextInt();
            if (price[i] < price[i - 1]) {
                diff = beer - dist[i];
                beer = dist[i];
            } else {
                diff = beer - trunk;
                beer = trunk;
            }
            profit += price[i - 1] * diff;
            beer -= dist[i];
        }
        if (beer > 0) {
            profit += price[price.length - 1] * beer;
        }
        System.out.println(profit);
    }
    public static void main(String[] args) {
        for (int c = sc.nextInt(); c > 0; c--) {
            new BeerPrices().run();
        }
    }
}
