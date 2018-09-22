package correct;
import java.util.Scanner;
public class WatchDog {
    static Scanner sc = new Scanner(System.in);
    void run() {
        int x = 0, y, l, dx, dy, h = 0, S = sc.nextInt(), px[] = new int[sc.nextInt()], py[] = new int[px.length];
        for (; h < px.length; h++) {
            px[h] = sc.nextInt();
            py[h] = sc.nextInt();
        }
        for (; x <= S; x++) {
            y:
            for (y = 0; y <= S; y++) {
                for (h = 0, l = (l = Math.min(x, Math.min(y, Math.min(S - x, S - y)))) * l; h < px.length; h++) {
                    if ((px[h] == x && py[h] == y) || (dx = px[h] - x) * dx + (dy = py[h] - y) * dy > l) {
                        continue y;
                    }
                }
                System.out.println(x + " " + y);
                return;
            }
        }
        System.out.println("poodle");
    }
    public static void main(String[] args) {
        for (int c = sc.nextInt(); c > 0; c--) {
            new WatchDog().run();
        }
    }
}