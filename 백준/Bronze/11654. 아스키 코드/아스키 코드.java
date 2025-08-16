import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char c = input.charAt(0);
        System.out.println((int) c);
        sc.close();
    }
}