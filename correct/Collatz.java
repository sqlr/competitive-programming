package correct;

/**
 * @date Oct 26, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.*;

public class Collatz {

    static Scanner scanner;

    public void run() {
        int n = scanner.nextInt();
        System.out.println(n + (n % 2) - (n + 2) / 6);
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        for (int c = scanner.nextInt(); c > 0; c--) {
            new Collatz().run();
        }
    }
}