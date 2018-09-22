package correct;

import java.util.*;
public class WorkingAtTheRestaurant {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        for (int N = sc.nextInt(); N != 0;) {
            for (int drop = 0, take = 0, act; N > 0; N--) {
                if (sc.next().equals("DROP")) {
                    drop += (act = sc.nextInt());
                    System.out.println("DROP 2 " + act);
                } else {
                    if ((act = sc.nextInt()) > take) {
                        if (take > 0) {
                            System.out.println("TAKE 1 " + take);
                            act -= take;
                        }
                        System.out.println("MOVE 2->1 " + (take = drop));
                        drop = 0;
                    }
                    System.out.println("TAKE 1 " + act);
                    take -= act;
                }
            }
            if ((N = sc.nextInt()) == 0) {
                return;
            }
            System.out.println();
        }
    }
}