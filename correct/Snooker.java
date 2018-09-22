package correct;


import java.util.*;

public class Snooker {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        frame:
        for (int c = sc.nextInt(); c > 0; c--, sc.nextLine()) {
            int left = 147, diff = 0, gone = 0, player = 1, cur = 1, max = sc.nextInt(), ball = sc.nextInt();
            boolean red = true;
            for (; gone < 30; cur++, red = (gone & 1) == 0, ball = sc.nextInt()) {
                if (ball == 0) {
                    player *= -1;
                    if (red) {
                        continue;
                    }
                }
                diff += player * ball;
                left -= red ? 3 : 5;
                gone++;
                if (diff > left || diff < -1 * left) {
                    System.out.println(cur);
                    continue frame;
                }
            }
            for (; cur <= max; cur++, ball = sc.nextInt()) {
                if (ball == 0) {
                    player *= -1;
                } else {
                    diff += player * ball;
                }
                left -= ball;
                if (diff > left || diff < -1 * left) {
                    System.out.println(cur);
                    continue frame;
                }
            }
            System.out.println(max);
        }
    }
}
