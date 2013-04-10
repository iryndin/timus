import java.io.*;
import java.io.IOException;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1409
 */
public class Timus1409 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int harry = scanner.nextInt();
        int larry = scanner.nextInt();

        PrintWriter out = new PrintWriter(System.out);
        out.println(larry-1);
        out.println(harry-1);
        out.flush();
    }
}