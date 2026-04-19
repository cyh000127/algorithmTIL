import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();  // 첫 항
        int d = sc.nextInt();  // 공차
        int k = sc.nextInt();  // 찾고 싶은 값
        
        // k가 등차수열의 항인지 확인
        if ((k - a) % d == 0) {
            int n = (k - a) / d + 1;
            if (n > 0) {
                System.out.println(n);
                return;
            }
        }
        
        System.out.println("X");
    }
}