import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ★ 4
		// ● 3
		// ■ 2
		// ▲ 1
		// 라운드 수 N ( N줄 출력)
		// 두 아이가 번갈아 딱지를 내게 됨

		// 두 줄이 A , B가 낸 카드들임
		// 각 줄의 맨 처음에는 낸 카드의 개수가 나옴
		// 라운드 수 N
		int N = Integer.parseInt(br.readLine());

		for (int test = 1; test <= N; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// a 카드
			int card1 = Integer.parseInt(st.nextToken());
			int[] a_card = new int[5];

			for (int i = 1; i <= card1; i++) {
				int t = Integer.parseInt(st.nextToken());
				a_card[t]++;
			}
			// b 카드
			st = new StringTokenizer(br.readLine());
			int card2 = Integer.parseInt(st.nextToken());
			int[] b_card = new int[5];

			for (int i = 1; i <= card2; i++) {
				int t = Integer.parseInt(st.nextToken());
				b_card[t]++;
			}

			// 뒤에서부터 for문을 돌려서 우승자를 정하시오
			char winner = 'D';
			for (int i = 4; i >= 1; i--) {
				if (a_card[i] > b_card[i]) {
					// 강한 카드 부터 계산
					// 카드 개수가 더 많은 순간 나감
					// a의 카드가 더 많다면 A의 우승
					winner = 'A';
					break;
				}  else if (a_card[i] < b_card[i]) {
					// b의 카드가 더 많다면 A의 우승
					winner = 'B';
					break;
				}
			}
		
		System.out.println(winner);
		}

	}
}
