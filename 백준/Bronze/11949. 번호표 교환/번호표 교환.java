import java.util.*;
import java.io.*;

/*
 * 11949 번호표 교환
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// n과 m 입력 받기
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 티켓 배열 입력 받기
		int[] nTicket = new int[n];
		for (int i = 0; i < n; i++) {
			nTicket[i] = sc.nextInt();
		}

		// 정렬 로직 (1부터 m까지의 i에 대해)
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j < n; j++) {
				// i로 나눈 나머지 값을 비교하여 스왑
				if (nTicket[j - 1] % i > nTicket[j] % i) {
					int temp = nTicket[j - 1];
					nTicket[j - 1] = nTicket[j];
					nTicket[j] = temp;
				}
			}
		}

		// 결과 출력
		for (int ticket : nTicket) {
			System.out.println(ticket);
		}

		sc.close();
	}
}