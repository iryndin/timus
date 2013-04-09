import java.io.*;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1014
 */
public class Timus1014 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long q = solve(n);

        PrintWriter out = new PrintWriter(System.out);
        out.println(q);
        out.flush();
    }

    static long solve(int n) {
        // check for some trivial cases
        if (n == 0) {
            return 10L;
        } else if (1 <= n && n <= 9) {
            return n;
        }

        final ArrayList<Integer> lst = new ArrayList<Integer>(20);

        // now run factorization
        while (true) {
            boolean doBreakWhile = true;
            for (int i = 9; i >= 2; i--) {
                if (n % i == 0) {
                    n /= i;
                    lst.add(i);
                    if (n < 10) {
                        lst.add(n);
                        return asMinimalNumber(lst);
                    } else {
                        doBreakWhile = false;
                    }
                }
            }
            if (doBreakWhile) break;
        }
        return -1L;
    }

    static long asMinimalNumber(final ArrayList<Integer> lst) {
        Collections.sort(lst);
        int sz = lst.size()-1;
        long result = 0;
        for (int i : lst) {
            result += i * pow(10, sz);
            sz--;
        }
        return result;
    }

    static long pow(int a, int b) {
        if (b < 0) throw new IllegalArgumentException("b < 0");
        if (a == 0) return 0;
        if (b == 0) return 1L;
        else if (b == 1) return a;

        long p = 1L;
        while (b > 0) {
            p *= a;
            b--;
        }
        return p;
    }
}