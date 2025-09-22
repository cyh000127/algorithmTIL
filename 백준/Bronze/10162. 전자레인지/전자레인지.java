import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// A 버튼 300s
		// B 버튼 60s
		// C 버튼 10s

		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		if (T % 10 != 0) {
			sb.append(-1);
		} else {
			if (T / 300 >= 1) {
				sb.append(T / 300).append(" ");

			} else {
				sb.append(0).append(" ");
			}

			int a = T % 300;
			if (a / 60 >= 1) {
				sb.append(a / 60).append(" ");
			} else {
				sb.append(0).append(" ");
			}

			int b = a % 60;
			if (b / 10 >= 1) {
				sb.append(b / 10).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb.toString().trim());
	}
}
