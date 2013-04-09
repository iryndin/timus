import java.io.*;
import java.io.IOException;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1510
 */
public class Timus1510 {

    /**
     * This runs ok
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int SZ = 4096*512;
        int n = Integer.parseInt(reader.readLine());
        int[] map = new int[SZ];

        int max = 0;
        int val = 0;
        while (n > 0) {
            int a = Integer.parseInt(reader.readLine());
            final int key = a % SZ;
            map[key]++;
            if (map[key] > max) {
                max = map[key];
                val = a;
            }
            n--;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(val);
        out.flush();
    }

    /**
     * This solution gives error: Time Limit Exceeded
     * This is due to usage of slooooow Scanner
     * @param args
     * @throws IOException
     */
    public static void timeLimitExceeded(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        final int SZ = 4096*512;
        int n = scanner.nextInt();
        int[] map = new int[SZ];

        int max = 0;
        int val = 0;
        while (n > 0) {
            int a = scanner.nextInt();
            final int key = a % SZ;
            map[key]++;
            if (map[key] > max) {
                max = map[key];
                val = a;
            }
            n--;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(val);
        out.flush();
    }

    /**
     * This solution gives Error: Memory limit exceeded
     * This is due to usage of HashMap
     * @param args
     */
    public static void memoryLimitExceeded(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        //Map<Integer, Integer> map = new HashMap<Integer, Integer>(1024, 1.0f);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(4096);

        int a=0;
        while (n > 0) {
            a = scanner.nextInt();
            Integer i = map.get(a);
            if (i == null) {
                i = 0;
            }
            i = i.intValue()+1;
            map.put(a,i);
            n--;
        }

        int max = map.get(a);
        int val = a;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                val = e.getKey();
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(val);
        out.flush();
    }
}