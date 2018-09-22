package correct;


import java.util.*;
import java.io.*;

public class EncodedMessage {

    static Scanner sc = new Scanner(System.in);

    public void run() {
        char[] line = sc.next().toCharArray();
        char[] out = new char[line.length];
        int sq = (int) Math.sqrt(line.length);
        for (int x = 0; x < sq; x++) {
            for (int y = 0; y < sq; y++) {
                out[x * sq + y] = line[(y + 1) * sq - x - 1];
            }
        }
        System.out.println(out);
    }

    public static void main(String[] args) {
        for (int c = sc.nextInt(); c > 0; c--) {
            new EncodedMessage().run();
        }
    }
}
