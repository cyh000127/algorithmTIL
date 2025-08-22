import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// M x N 보드
		// 흰 , 검 칠하기
		// W로 싹 칠해보고
		// B로 싹 칠해보고
		// math.min 해서 출력

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		int minChanges = Integer.MAX_VALUE;

		// 모든 8x8 부분 보드를 탐색
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {

				int changesCase1 = 0; // 시작이 'W'인 경우
				int changesCase2 = 0; // 시작이 'B'인 경우

				for (int row = i; row < i + 8; row++) {
					for (int col = j; col < j + 8; col++) {
						// (row + col)의 합이 짝수인지 홀수인지에 따라 올바른 색상 판별
						if ((row + col) % 2 == 0) {
							// Case 1: 시작이 'W'
							if (board[row][col] != 'W') {
								changesCase1++;
							}
							// Case 2: 시작이 'B'
							if (board[row][col] != 'B') {
								changesCase2++;
							}
						} else {
							// Case 1: 시작이 'W'
							if (board[row][col] != 'B') {
								changesCase1++;
							}
							// Case 2: 시작이 'B'
							if (board[row][col] != 'W') {
								changesCase2++;
							}
						}
					}
				}

				int currentChanges = Math.min(changesCase1, changesCase2);
				if (currentChanges < minChanges) {
					minChanges = currentChanges;
				}
			}
		}

		System.out.println(minChanges);
	}
}