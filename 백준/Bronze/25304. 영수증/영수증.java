import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long totalPrice = sc.nextLong();
		int product = sc.nextInt();
		int sum = 0;
		
		for(int i=0; i<product; i++) {
			int price = sc.nextInt();
			int cnt = sc.nextInt();
			
			sum += price * cnt;
		}
		if(totalPrice == sum) {
			System.out.println("Yes");
		} else System.out.println("No");
	}
}