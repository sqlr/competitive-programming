package correct;


import java.util.*;

public class DigitSum {

    static Scanner sc = new Scanner(System.in);
    static long[] add = new long[17];
    static int[] addsmall = new int[100];

    public void run() {
        long tmp = sc.nextLong();
        System.out.println(calc(sc.nextLong()) - calc(tmp - 1));
    }

    long calc(long in) {
        if (in < 0) {
            return 0;
        }
        long had = in % 100, pow = 100, times = 1, cur;
        long sum = addsmall[(int) had];
        in /= 100;

        while (in != 0) {
            cur = in % 10;
            in /= 10;
            sum += (had + 1) * cur;
            sum += cur * add[(int) times];
            if (cur > 0) {
                sum += addsmall[(int) (cur + 9) % 10] * pow;
            }
            had += cur * pow;
            times++;
            pow *= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        add[0] = 45l;
        add[1] = 900l;
        add[2] = 13500l;
        add[3] = 180000l;
        add[4] = 2250000l;
        add[5] = 27000000l;
        add[6] = 315000000l;
        add[7] = 3600000000l;
        add[8] = 40500000000l;
        add[9] = 450000000000l;
        add[10] = 4950000000000l;
        add[11] = 54000000000000l;
        add[12] = 585000000000000l;
        add[13] = 6300000000000000l;
        add[14] = 67500000000000000l;
        add[15] = 720000000000000000l;
        add[16] = 7650000000000000000l;

        addsmall[0] = 0;
        addsmall[1] = 1;
        addsmall[2] = 3;
        addsmall[3] = 6;
        addsmall[4] = 10;
        addsmall[5] = 15;
        addsmall[6] = 21;
        addsmall[7] = 28;
        addsmall[8] = 36;
        addsmall[9] = 45;
        addsmall[10] = 46;
        addsmall[11] = 48;
        addsmall[12] = 51;
        addsmall[13] = 55;
        addsmall[14] = 60;
        addsmall[15] = 66;
        addsmall[16] = 73;
        addsmall[17] = 81;
        addsmall[18] = 90;
        addsmall[19] = 100;
        addsmall[20] = 102;
        addsmall[21] = 105;
        addsmall[22] = 109;
        addsmall[23] = 114;
        addsmall[24] = 120;
        addsmall[25] = 127;
        addsmall[26] = 135;
        addsmall[27] = 144;
        addsmall[28] = 154;
        addsmall[29] = 165;
        addsmall[30] = 168;
        addsmall[31] = 172;
        addsmall[32] = 177;
        addsmall[33] = 183;
        addsmall[34] = 190;
        addsmall[35] = 198;
        addsmall[36] = 207;
        addsmall[37] = 217;
        addsmall[38] = 228;
        addsmall[39] = 240;
        addsmall[40] = 244;
        addsmall[41] = 249;
        addsmall[42] = 255;
        addsmall[43] = 262;
        addsmall[44] = 270;
        addsmall[45] = 279;
        addsmall[46] = 289;
        addsmall[47] = 300;
        addsmall[48] = 312;
        addsmall[49] = 325;
        addsmall[50] = 330;
        addsmall[51] = 336;
        addsmall[52] = 343;
        addsmall[53] = 351;
        addsmall[54] = 360;
        addsmall[55] = 370;
        addsmall[56] = 381;
        addsmall[57] = 393;
        addsmall[58] = 406;
        addsmall[59] = 420;
        addsmall[60] = 426;
        addsmall[61] = 433;
        addsmall[62] = 441;
        addsmall[63] = 450;
        addsmall[64] = 460;
        addsmall[65] = 471;
        addsmall[66] = 483;
        addsmall[67] = 496;
        addsmall[68] = 510;
        addsmall[69] = 525;
        addsmall[70] = 532;
        addsmall[71] = 540;
        addsmall[72] = 549;
        addsmall[73] = 559;
        addsmall[74] = 570;
        addsmall[75] = 582;
        addsmall[76] = 595;
        addsmall[77] = 609;
        addsmall[78] = 624;
        addsmall[79] = 640;
        addsmall[80] = 648;
        addsmall[81] = 657;
        addsmall[82] = 667;
        addsmall[83] = 678;
        addsmall[84] = 690;
        addsmall[85] = 703;
        addsmall[86] = 717;
        addsmall[87] = 732;
        addsmall[88] = 748;
        addsmall[89] = 765;
        addsmall[90] = 774;
        addsmall[91] = 784;
        addsmall[92] = 795;
        addsmall[93] = 807;
        addsmall[94] = 820;
        addsmall[95] = 834;
        addsmall[96] = 849;
        addsmall[97] = 865;
        addsmall[98] = 882;
        addsmall[99] = 900;

        for (int c = sc.nextInt(); c > 0; c--) {
            new DigitSum().run();
        }
    }
}
