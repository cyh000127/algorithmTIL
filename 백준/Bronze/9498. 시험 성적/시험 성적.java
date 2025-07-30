import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		if(score/10 > 8) {
			System.out.println("A");
		} else if(score/10 > 7) {
			System.out.println("B");
		} else if(score/10 > 6) {
			System.out.println("C");
		} else if(score/10 > 5) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}	
}