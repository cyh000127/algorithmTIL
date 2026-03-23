import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		StringBuilder answer = new StringBuilder();

		// 상단 테두리
		answer.append("|");
		for (int i = 0; i < size - 2; i++) {
			answer.append("-");
		}
		answer.append("|").append("\n");

		// 내부 콘텐츠 (X자 모양)
		for (int i = 0; i < size - 2; i++) {
			answer.append("|");
			for (int j = 0; j < size - 2; j++) {
				// i == j (왼쪽 위 -> 오른쪽 아래 대각선)
				// size - 3 - i == j (오른쪽 위 -> 왼쪽 아래 대각선)
				if (i == j || (size - 3 - i) == j) {
					answer.append("*");
				} else {
					answer.append(" ");
				}
			}
			answer.append("|").append("\n");
		}

		// 하단 테두리
		answer.append("|");
		for (int i = 0; i < size - 2; i++) {
			answer.append("-");
		}
		answer.append("|");

		System.out.println(answer.toString());
		sc.close();
	}
}