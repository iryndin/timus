import java.io.*;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1068
 */
public class Timus1068 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long s = solve(n);

        PrintWriter out = new PrintWriter(System.out);
        out.println(s);
        out.flush();
    }

    static long solve(int n) {
        if (n < 1) {
            return sum(n,1);
        } else {
            return sum(1,n);
        }
    }

    static long sum(int a, int b) {
        long res = 0;
        if (a > b) throw new IllegalArgumentException("a > b");
        while (a <= b) {
            res += a;
            a++;
        }
        return res;
    }
}