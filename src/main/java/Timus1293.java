import java.io.*;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1293
 */
public class Timus1293 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int A = scanner.nextInt();
        final int B = scanner.nextInt();

        final int res = 2*N*A*B;

        PrintWriter out = new PrintWriter(System.out);
        out.println(res);
        out.flush();
    }
}