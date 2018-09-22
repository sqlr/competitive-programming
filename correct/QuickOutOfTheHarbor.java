package correct;

/**
 * @date Oct 24, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class QuickOutOfTheHarbor {

    static Scanner sc = new Scanner(System.in);
    
    void run() {
        int height = sc.nextInt();
        int width  = sc.nextInt();
        int delay  = sc.nextInt();
        sc.nextLine();
        
        int[][] map  = new int[width][height];
        int[][] info = new int[width][height];

        PriorityQueue<Triple> queue = new PriorityQueue<Triple>();

        for (int y = 0; y < height; y++) {
            char[] line = sc.nextLine().toCharArray();
            for (int x = 0; x < width; x++) {
                if (line[x] == '#') {
                    map[x][y] = -1;
                } else if (line[x] == 'S') {
                    if (x == 0 || x == width-1 || y == 0 || y == height-1) {
                        System.out.println(1);
                        return;
                    }
                    queue.add(new Triple(0, x, y));
                    info[x][y] = 5;
                } else if (line[x] == '@') {
                    info[x][y] = 2;
                }
            }
        }
        
        int[][] off = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            Triple p = queue.poll();
            for (int[] o: off) {
                if (map[p.x+o[0]][p.y+o[1]] >= 0 && (info[p.x+o[0]][p.y+o[1]] & 1) == 0) {
                    int time = p.time + 1 + ((info[p.x+o[0]][p.y+o[1]] & 2) == 2 ? delay : 0);
                    if (p.x+o[0] == 0 || p.x+o[0] == width-1 || p.y+o[1] == 0 || p.y+o[1] == height-1) {
                        System.out.println(time+1);
                        return;
                    }
                    queue.add(new Triple(time, p.x+o[0], p.y+o[1]));
                    info[p.x+o[0]][p.y+o[1]] |= 1;
                }
            }
        }
    }

    class Triple implements Comparable<Triple> {
        int time, x, y;
        Triple(int time, int x, int y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Triple other) {
            if (other.time < this.time) {
                return 1;
            } else if (this.time < other.time) {
                return -1;
            }
            return 0;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) new QuickOutOfTheHarbor().run();
    }
}
