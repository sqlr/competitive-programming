package correct;

/**
 * @date Oct 17, 2011
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.io.*;
import java.util.*;

class FairDivision {

    static Scanner sc;

    void run() {
        int price = sc.nextInt();
        int people = sc.nextInt();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>();
        int max;
        int sum = 0;
        for (int i = 0; i < people; i++) {
            max = sc.nextInt();
            sum += max;
            pq.add(new Pair(max, people-i));
        }
        if (sum < price) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        int[] pay = new int[people];
        Pair<Integer, Integer> person;
        for (int i = 0; i < people; i++) {
            person = pq.poll();
            pay[people-person.second] = Math.min(person.first, price/(people-i));
            price -= pay[people-person.second];
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < people; i++) {
            builder.append(pay[i]).append(" ");
        }
        System.out.println(builder.toString().trim());
        return;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            new FairDivision().run();
        }
    }

    class Pair<E, F> implements Comparable<Pair<E, F>> {
        E first;
        F second;
        Pair(E first, F second) {
            super();
            this.first = first;
            this.second = second;
        }
        // Additional functions:
        @Override
        public boolean equals(Object other) {
            if (other instanceof Pair) {
                Pair otherPair = (Pair) other;
                return ((this.first == otherPair.first
                        || (this.first != null && otherPair.first != null
                        && this.first.equals(otherPair.first)))
                        && (this.second == otherPair.second
                        || (this.second != null && otherPair.second != null
                        && this.second.equals(otherPair.second))));
            }
            return false;
        }
        public int compareTo(Pair<E, F> otherPair) {
            if (first instanceof Comparable) {
                final int k = ((Comparable<E>) first).compareTo(otherPair.first);
                if (k > 0) {
                    return 1;
                }
                if (k < 0) {
                    return -1;
                }
            }
            if (second instanceof Comparable) {
                final int k = ((Comparable<F>) second).compareTo(otherPair.second);
                if (k > 0) {
                    return 1;
                }
                if (k < 0) {
                    return -1;
                }
            }
            return 0;
        }
    }
}