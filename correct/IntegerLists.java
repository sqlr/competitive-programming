package correct;


import java.util.*;
import java.io.*;

public class IntegerLists {

    static Scanner sc = new Scanner(System.in);
    
    public void run() {
        char[] f = sc.next().toCharArray();
        int[] l = new int[sc.nextInt()];
        char[] in = sc.next().toCharArray();
        int tmp = 0, x = 0;
        for (int i = 1; i < in.length - 1; i++) {
            if (in[i] == ',') {
                l[x] = tmp;
                tmp = 0;
                x++;
            } else {
                tmp = tmp * 10 + (in[i] - '0');
            }
        }
        if (l.length != 0) {
            l[x] = tmp;
        }
        boolean rev = false;
        boolean error = false;
        int s = 0;
        int e = l.length;
        buitenloop:
        for (char c : f) {
            switch (c) {
                case 'R':
                    rev = !rev;
                    break;
                case 'D':
                    if (s == e) {
                        error = true;
                        break buitenloop;
                    } else {
                        if (rev) {
                            e--;
                        } else {
                            s++;
                        }
                    }
            }
        }
        if (error) {
            System.out.println("error");
        } else if (rev) {
            PrintWriter w=new PrintWriter(System.out);
            w.print("[");
            for (int i = 0; i < e - s; i++) {
                if (i != 0) {
                    w.print(",");
                }
                w.print(l[e - i - 1]);
            }
            w.println("]");
            w.flush();
        } else {
            PrintWriter w=new PrintWriter(System.out);
            w.print("[");
            for (int i = s; i < e; i++) {
                if (i != s) {
                    w.print(",");
                }
                w.print(l[i]);
            }
            w.println("]");
            w.flush();
        }
    }

    public static void main(String[] args) {
        for (int c = sc.nextInt(); c > 0; c--) {
            new IntegerLists().run();
        }
    }
}
