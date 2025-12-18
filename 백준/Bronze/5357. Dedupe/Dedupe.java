import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int j;
		for(int i = 0; i < n; i++) {
			String a = sc.next();
			for(j = 0; j < a.length() - 1; j++) {
				if(a.charAt(j) != a.charAt(j + 1)) {
					System.out.print(a.charAt(j));
				}
			}
			System.out.println(a.charAt(j));
		}
		sc.close();
	}
}