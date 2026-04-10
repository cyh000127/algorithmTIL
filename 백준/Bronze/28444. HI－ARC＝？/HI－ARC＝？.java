import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int h = scanner.nextInt();
        int i = scanner.nextInt();
        int a = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        
        System.out.println((h * i) - (a * r * c));
    }
}