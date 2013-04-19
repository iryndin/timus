import java.io.*;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1264
 */
public class Timus1264 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int result = (m + 1) * n;

        PrintWriter out = new PrintWriter(System.out);
        out.println(result);
        out.flush();
    }
}