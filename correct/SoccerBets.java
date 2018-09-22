package correct;

/**
 * @date Jan 16, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.*;
import java.text.*;

public class SoccerBets {

    public static Scanner scanner;

    public void run () {
        String[] teamnums = new String[8];
        int[] wins = new int[8];

        for (int i = 0; i < 16; i++) {
            String team1    = scanner.next();
            String team2    = scanner.next();
            int score1      = scanner.nextInt();
            int score2      = scanner.nextInt();

            String matchWinner = score1 > score2 ? team1 : team2;
            int num = 0;

            while (num < 8) {
                if (teamnums[num] == null) {
                    teamnums[num] = matchWinner;
                    wins[num]++;
                } else if (teamnums[num].equals(matchWinner)) {
                    wins[num]++;
                } else {
                    num++;
                    continue;
                }
                break;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (wins[i] == 4) {
                System.out.println(teamnums[i]);
            }
        }

        return;
    }

    public static void main (String[] args) {
        scanner = new Scanner(System.in);
        for (int c = scanner.nextInt(); c > 0; c--) {
            new SoccerBets().run();
        }
        return;
    }
}