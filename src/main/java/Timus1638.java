import java.io.*;
import java.util.*;

/**
 * http://acm.timus.ru/problem.aspx?space=1&num=1638
 */
public class Timus1638 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int volThickness = scanner.nextInt();
        final int coverThickness = scanner.nextInt();
        final int startVol = scanner.nextInt();
        final int endVol = scanner.nextInt();

        int res = 0;
        if (endVol == startVol) {
            res = volThickness;
        } else if (endVol > startVol) {
            res = 2*coverThickness + (volThickness + 2*coverThickness)*(endVol-startVol-1);
        } else {
            // endVol < startVol
            res = volThickness + (volThickness + 2*coverThickness)*(startVol-endVol);
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(res);
        out.flush();
    }
}