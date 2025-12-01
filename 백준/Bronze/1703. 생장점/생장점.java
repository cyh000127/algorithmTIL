import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		while(n != 0) {
			int total = 1;
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				total *= a;
				total -= b;
			}
			System.out.println(total);
			n = sc.nextInt();
		}
		sc.close();
	}
}