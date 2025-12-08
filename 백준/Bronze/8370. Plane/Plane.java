import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2, k1, k2;

        n1 = sc.nextInt();
        k1 = sc.nextInt();
        n2 = sc.nextInt();
        k2 = sc.nextInt();
        sc.close();

        System.out.println((n1*k1)+(n2*k2));
    }
}