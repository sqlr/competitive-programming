import java.util.*;

class HighScore {

    static Scanner sc = new Scanner(System.in);

    void run() {
        char[] name = sc.next().toCharArray();
        int[] cost = new int[name.length];
        for (int i = 0; i < name.length; i++) {
            cost[i] = Math.min(name[i] - 'A', 'Z' - name[i] + 1);
        }
    }

    public static void main(String[] args) {
        for (int c = sc.nextInt(); c > 0; c--) {
            new HighScore().run();
        }
    }
}