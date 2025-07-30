import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		// Quadrant
		int Q = 0;
		if(x>0) {
			if(y>0) {
				Q = 1;
			} else Q=4;
		} else {
			if(y>0) {
				Q=2;
			} else Q=3;
		}
	System.out.println(Q);
	}
}