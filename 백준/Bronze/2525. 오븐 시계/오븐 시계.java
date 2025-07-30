import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int M = sc.nextInt();
		// 오븐 시간
		int O = sc.nextInt();

		System.out.print((H+((O+M)/60))%24 + " ");
		System.out.println((O+M)%60);
	}
}