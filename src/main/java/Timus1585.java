import java.io.*;
import java.io.IOException;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1585
 */
public class Timus1585 {

    /**
     * This runs ok
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int e=0, m=0, l=0;
        int n = Integer.parseInt(reader.readLine());

        while (n > 0) {
            String s = reader.readLine();
            if (s.startsWith("E")) {
                e++;
            } else if (s.startsWith("M")) {
                m++;
            } else if (s.startsWith("L")) {
                l++;
            }
            
            n--;
        }
        
        PrintWriter out = new PrintWriter(System.out);
        if (e >= m && e >= l) {
            out.println("Emperor Penguin");
        } else if (m >= e && m >= l) {
            out.println("Macaroni Penguin");
        } else if (l >= e && l >= m) {
            out.println("Little Penguin");
        }
        out.flush();
    }
}