package correct;

/**
 * @date Oct 25, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.text.*;
import java.util.*;

public class WalkingTheDog {

    static Scanner scanner ;

    public void run() {

        int fromx = 0, fromy = 0;
        double angle = 0.0, froma;

        int points  = scanner.nextInt();
        int tox     = scanner.nextInt();
        int toy     = scanner.nextInt();
        double toa  = arg(tox, toy);
        
        for (int i = 1; i < points; i++) {
            fromx = tox;
            fromy = toy;
            froma = toa;
            
            tox = scanner.nextInt();
            toy = scanner.nextInt();

            toa = arg(tox, toy);

            if (toa - froma == Math.PI || froma - toa == Math.PI) {
                angle += Math.PI;
            } else if (froma - toa > Math.PI) {
                angle += toa + 2 * Math.PI - froma;
            } else if (toa - froma <= 0) {
                angle += toa - froma;
            } else if (toa - froma < Math.PI) {
                angle += toa - froma;
            } else {
                angle += toa - froma - 2 * Math.PI;
            }
        }

        DecimalFormat format = new DecimalFormat("#");
        System.out.println(format.format(Math.floor(
                Math.abs(angle / (2 * Math.PI)))));
    }

    double arg(int x, int y) {
        if (y == 0) {
            return Math.PI * (1 - Math.abs(x) / x) / 2;
        } else {
            int ggd = ggd(Math.abs(x), Math.abs(y));
            x /= ggd;
            y /= ggd;
            return (Math.abs(y) / y) * Math.acos(x / Math.sqrt(x * x + y * y)) ;
        }
    }

    int ggd(int a, int b) {
        return b == 0 ? a : ggd(b, a % b) ;
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        for (int c = scanner.nextInt(); c > 0; c--) {
            new WalkingTheDog().run();
        }
    }

}