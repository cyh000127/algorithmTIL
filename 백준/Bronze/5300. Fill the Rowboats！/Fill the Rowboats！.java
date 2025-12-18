import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                System.out.print(i + " Go!");
            }
            else if (i % 6 == 0) {
                System.out.print(i + " Go! ");
            }
            else {
                System.out.print(i + " ");
            }
        }
 
    }
}