package correct;

import java.util.*;

public class AbsurdPrices {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        for (int c = sc.nextInt(); c > 0; c--) {
            int in = sc.nextInt();
            while (in % 10 == 0) {
                in /= 10;
            }
            if (in < 10) {
                System.out.println("not absurd");
                continue;
            }
            boolean notfive = (in % 10) != 5;
            double test = in - (in % 10), ind = in;
            if (test >= 0.95 * ind && test <= 1.05 * ind) {
                System.out.println("absurd");
                continue;
            }
            if (notfive && test + 5.0d >= 0.95 * ind && test + 5.0d <= 1.05 * ind) {
                System.out.println("absurd");
                continue;
            }
            if (test + 10.0d >= 0.95 * ind && test + 10.0d <= 1.05 * ind) {
                System.out.println("absurd");
                continue;
            }
            System.out.println("not absurd");
        }
    }
}
