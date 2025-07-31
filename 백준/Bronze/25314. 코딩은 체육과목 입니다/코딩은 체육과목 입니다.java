import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		String G = "long int";
		
		for(int i=0; i < A/4-1; i++) {
			System.out.print("long ");
		}
		System.out.println(G);
	}
}