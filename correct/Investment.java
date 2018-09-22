package correct;

import java.util.*;

public class Investment {
    static Scanner sc = new Scanner(System.in);
    void run() {
        int capital = sc.nextInt(), years = sc.nextInt(), dp[] = new int[45245], i, j, opt;
        Bond[] bonds = new Bond[sc.nextInt()];
        for (i = 0; i < bonds.length; i++) {
            bonds[i] = new Bond(sc.nextInt(), sc.nextInt());
        }
        // for each possible capital, store what the maximum interest is
        for (i = 0; i < dp.length; i++) {
            for (j = 0, dp[i] = 0; j < bonds.length; j++) {
                if ((opt = i - (bonds[j].value/1000)) >= 0) {
                    dp[i] = Math.max(dp[i], bonds[j].interest + dp[opt]);
                }
            }
        }
        for (i = 0; i < years; i++) {
            capital += dp[capital/1000];
        }
        System.out.println(capital);
    }
    class Bond {
        int value, interest;
        Bond(int value, int interest) {
            this.value = value;
            this.interest = interest;
        }
    }
    public static void main(String[] args) {
        for (int c = sc.nextInt(); c > 0; c--) {
            new Investment().run();
        }
    }
}
