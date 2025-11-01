import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int A = sc.nextInt();
      int B = sc.nextInt();
      int C = sc.nextInt();

      int middle = 0;
      if (A >= B) {
         if (B >= C) {
            middle = B;
         }
         else if (C >= A) {
            middle = A;
         }
         else {
            middle = C;
         }
      } else if (A > C) {
         middle = A;
      } else if (B > C) {
         middle = C;
      } else {
         middle = B;
      }
      System.out.println(middle);
   }
}