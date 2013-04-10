import java.io.*;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1197
 */
public class Timus1197 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(reader.readLine());

        for (int i=0; i<n; i++) {
            String s = reader.readLine();
            int a = solve(s);
            out.println(a);
        }
        out.flush();
    }

    static int solve(String s) {
        int c = mapCharToInt(s.charAt(0));
        int d = Integer.parseInt(""+s.charAt(1));
        int res = 0;
        if (c+1 < 9) {
            if (d+2 < 9) res++;
            if (d-2 > 0) res++;
        }
        if (c+2 < 9) {
            if (d+1 < 9) res++;
            if (d-1 > 0) res++;
        }
        if (c-1 > 0) {
            if (d+2 < 9) res++;
            if (d-2 > 0) res++;
        }

        if (c-2 > 0) {
            if (d+1 < 9) res++;
            if (d-1 > 0) res++;
        }
        return res;
    }

    static int mapCharToInt(char c) {
        switch (c) {
            case 'a': return 1;
            case 'b': return 2;
            case 'c': return 3;
            case 'd': return 4;
            case 'e': return 5;
            case 'f': return 6;
            case 'g': return 7;
            case 'h': return 8;
        }
        throw new IllegalArgumentException("wrong char: " + c);
    }
}