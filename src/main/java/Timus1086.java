import java.io.*;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1086
 */
public class Timus1086 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] result = solve(a);

        PrintWriter out = new PrintWriter(System.out);
        for (long l : result) {
            out.println(l);
        }
        out.flush();
    }

    static long[] solve(int[] a) {
        int maxval = findMax(a);
        long[] primeNumbers = new long[a.length];
        ArrayList<Long> allPrimes = findFirstNPrimeNumbers(maxval);
        for (int i=0; i < a.length; i++) {
            primeNumbers[i] = allPrimes.get(a[i]-1);
        }
        return primeNumbers;
    }

    static int findMax(int[] a) {
        int max = a[0];
        for (int i=1; i<a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    static ArrayList<Long> findFirstNPrimeNumbers(int N) {
        ArrayList<Long> l = new ArrayList<Long>(N);
        l.add(2L);
        if (l.size() == N) {
            return l;
        }
        long max = 100000;

        findPrimesInInterval(3, max, l);
        while (l.size() < N) {
            findPrimesInInterval(max+1, max*2, l);
            max = max*2;
        }

        while (l.size() > N) {
            l.remove(l.size()-1);
        }
        return l;
    }

    /**
     * Find primes in interval [A,B] using already found primes
     * See
     * http://habrahabr.ru/post/122538/
     * http://habrahabr.ru/post/133037/
     */
    static void findPrimesInInterval(long A, final long B, final ArrayList<Long> primes) {
        for (; A <= B; A += 2) {
            if (A > 10 && A%10 == 5) {
                continue;
            }
            boolean b = true;
            for (long j : primes) {
                if (j > (Math.sqrt(A)+1)) {
                    primes.add(A);
                    b = false;
                    break;
                }
                if (A % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                primes.add(A);
            }
        }
    }
}