import java.io.*;
import java.util.*;
import java.util.HashSet;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1209
 */
public class Timus1209 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        int max = 0;
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] > max) {
                max = a[i];
            }
        }

        int[] result = solve(a,max);

        PrintWriter out = new PrintWriter(System.out);
        for (int i : result) {
            out.print(i + " ");
        }
        out.flush();
    }

    static int[] solve(int[] a, int max) {
        int[] sorted = new int[a];
        System.arraycopy(a,0,sorted,0,a.length);
        Arrays.sort(sorted);

        /*
        int[] result = new int[a.length];
        for (int i=0; i<a.length; i++) {
            if (unitPositions.contains(a[i])) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
        */
    }

    static int[] solve_memoryLimitExceeded(int[] a, int max) {
        Set<Integer> unitPositions = calculateUnitPositions(max);
        int[] result = new int[a.length];
        for (int i=0; i<a.length; i++) {
            if (unitPositions.contains(a[i])) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    static Set<Integer> calculateUnitPositions(int max) {
        Set<Integer> set = new HashSet<>(max/10+64);
        int add=0, current=1;
        while (current < max) {
            current+=add;
            set.add(current);
            add++;
        }
        return set;
    }
}