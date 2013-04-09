import java.io.*;
import java.util.*;

public class Timus1005
{
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      
      int n = scanner.nextInt();
      int[] stones = new int[n];
      
      for (int i=0; i<n; i++) {
          stones[i] = scanner.nextInt();
      }
      
      int diff = bruteForce(stones);
      
      PrintWriter out = new PrintWriter(System.out);
      out.println(diff);
      out.flush();
   }
   
   static int bruteForce(int[] stones) {
       final int N = stones.length;
       final int LIMIT = (1 << N)-1;
       int diff = Integer.MAX_VALUE;
       
       for (int i=0; i<LIMIT; i++) {
           int sum1=0, sum2=0;
           int k=i;
           for (int j=0; j<N; j++) {
               if ((k & 0x1) == 0) sum1+=stones[j];
               else sum2+=stones[j];
               k = k>>1;
           }
           int diffi = (sum1>=sum2) ? sum1-sum2 : sum2-sum1;
           if (diffi<diff) diff = diffi;
       }
       return diff;
   }
}