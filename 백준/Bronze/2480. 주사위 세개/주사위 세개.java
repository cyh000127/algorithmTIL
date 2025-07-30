import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int award = 0;
		if(a==c && a==b && b==c) {
			award = 10000 + a*1000;
		} else if(a==b || b==c || a==c) {
			if(a==b || a==c) {
				award = 1000 + a*100; 
			} else award = 1000 +b*100;
		} else {
			int m = Math.max(a, Math.max(c, b));
			award = m *100;
		}
		System.out.println(award);
	}
}