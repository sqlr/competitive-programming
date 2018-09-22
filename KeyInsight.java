
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class KeyInsight {

    static Scanner sc;
    static PrintWriter out;
    BigInteger sum;
    int blocksize;
    boolean[] taken;
    ArrayList<Integer>[] possible;
    HashMap<String, Integer> HM = new HashMap<String, Integer>();

    void run() {
        blocksize = sc.nextInt();
        sc.nextLine();
        taken = new boolean[blocksize];
        possible = new ArrayList[blocksize];
        char[] m = sc.nextLine().toCharArray();
        char[] c = sc.nextLine().toCharArray();
        int[] cnt = new int[101];
        int[] elm = new int[101];
        for (int mi = 0; mi < blocksize; mi++) {
            possible[mi] = new ArrayList<Integer>();
            continme:
            for (int ci = 0; ci < blocksize; ci++) {
                if (m[mi] == c[ci]) {
                    for (int ki = blocksize; ki < m.length; ki += blocksize) {
                        if (m[ki + mi] != c[ki + ci]) {
                            continue continme;
                        }
                    }
                    possible[mi].add(ci);
                    taken[ci] = true;
                }
            }
            if (possible[mi].isEmpty()) {
                out.println(0);
                return;
            }
            String temp = possible[mi].toString();
            if (HM.containsKey(temp)) {
                cnt[HM.get(temp)]++;
                elm[HM.get(temp)] = possible[mi].size();
            }else {
                cnt[HM.size()]++;
                elm[HM.size()]++;
                HM.put(temp, HM.size());
            }
        }
        sum = new BigInteger("1");
        for (String tmp: HM.keySet()) {
            sum = sum.multiply(fac[elm[HM.get(tmp)]]);
        }
        out.println(sum);
    }
    
    static BigInteger[] fac = new BigInteger[101];

    public static void main(String[] args) throws IOException {
        sc = new Scanner(new FileReader("key.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("key.out")));
        fac[0] = new BigInteger("1");
        for (int n = 1; n < fac.length; n++) {
            fac[n] = new BigInteger(Integer.toString(n));
            fac[n] = fac[n].multiply(fac[n-1]);
        }
        
        while (sc.hasNext()) {
            new KeyInsight().run();
        }
        out.close();
    }
}
