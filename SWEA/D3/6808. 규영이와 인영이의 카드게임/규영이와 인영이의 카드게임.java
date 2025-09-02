import java.io.*;
import java.util.*;

public class Solution {
	static int[] gyuu, young;
	static boolean[] card;
	static int win;
	static boolean[] youngcard;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			// 1에서 18까지의 카드 18장
			// 2명이서 9장씩 나눠가진다
			// 한라운드에 한장씩 내서 카드 수를 비교
			// 높은카드 -> 두 카드의 합 만큼 점수를 얻음
			// 낮은 카드 -> 점수를 얻을 수 없음
			// 총점이 높으면 이김, 같으면 무승부

			// 영규는 9장의 카드를 받는다
			// 영규가 내는 카드를 고정 -> 영인이만 카드를 냄
			// 영규가 이기는 경우, 지는 경우를 구하는 프로그램 작성

			// 1. 영인이가 가지고 있는 카드를 구해야함.
			card = new boolean[19];// 1부터 18까지

			gyuu = new int[9];
			young = new int[9];

			// 초기화
			win = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int a = Integer.parseInt(st.nextToken());
				gyuu[i] = a; // 순서대로 배열에 담기
				card[a] = true; // card가 false면 영인이 , true면 영규거
			}
			// card 배열을 직접 참조하면서 돌리려고 했으나 그러면 반복문이 19번씩 돌기 떄문에
			// 영인이의 카드 배열을 직접 찾아줄것
			int x = 0;
			youngcard = new boolean[9];

			for (int i = 1; i < 19; i++) {
				if (!card[i]) {
					young[x++] = i;
				}
			}

			// 재귀를 통한 승패 찾기
			fight(0, 0); 
			sb.append(win).append(" ").append(362_880 - win);
			//승,패의 경우의 수 밖에 없기 때문에 전체 횟수 9! 에서 승리를 뺌
			System.out.println(sb.toString().trim());
			sb.setLength(0);
		}

	}

	// now값 양수 -> 영규 승
	// now값 음수 -> 영규 패
	// now값 == 0 -> 영규 무승부! --> 171는 홀수이기 때문에 이경우는 발생하지 않음

	private static void fight(int round, int now) {
		// 1부터 18까지의 합 171
		// now가 171/2 ==> 85.5 -> 86 --> now < 86

		
		if (now >= 86) { // 가지 치기: 규영 승리 확정
			int rem = 9 - round; // 남은 라운드 수
			int add = 1; // rem! 계산
			for (int i = 2; i <= rem; i++)
				add *= i;
			win += add; // 남은 모든 경우의 수를 승리로 합산
			return;
		}

		
		if (round == 9) {
			// 모든 라운드가 지났으면 return 하셈
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!youngcard[i]) {
				youngcard[i] = true;
				int nextnow = now;
				if (young[i] < gyuu[round]) { // gyuu가 더 높아야 이길 수 있음
					nextnow += gyuu[round] + young[i]; // 이기면 점수 +
				}
				fight(round + 1, nextnow);
				youngcard[i] = false;
			}
		}

	}
}
