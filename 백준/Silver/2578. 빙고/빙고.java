import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 빙고판의 숫자를 지우고 빙고 여부를 확인하는 메서드
	public static int checkBingo(int[][] board) {
		int bingoCount = 0;

		// 가로줄 확인
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				sum += board[i][j];
			}
			if (sum == 0) {
				bingoCount++;
			}
		}

		// 세로줄 확인
		for (int j = 0; j < 5; j++) {
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				sum += board[i][j];
			}
			if (sum == 0) {
				bingoCount++;
			}
		}

		// 대각선 (정방향) 확인
		int sum1 = 0;
		for (int i = 0; i < 5; i++) {
			sum1 += board[i][i];
		}
		if (sum1 == 0) {
			bingoCount++;
		}

		// 대각선 (역방향) 확인
		int sum2 = 0;
		for (int i = 0; i < 5; i++) {
			sum2 += board[i][4 - i];
		}
		if (sum2 == 0) {
			bingoCount++;
		}

		return bingoCount;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 빙고판 초기화 및 값 할당
		int[][] bingoBoard = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingoBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자가 부르는 수 입력 및 처리
		int callCount = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int calledNum = Integer.parseInt(st.nextToken());
				callCount++;

				// 2차원 배열을 순차적으로 탐색하여 숫자 지우기
				for (int row = 0; row < 5; row++) {
					for (int col = 0; col < 5; col++) {
						if (bingoBoard[row][col] == calledNum) {
							bingoBoard[row][col] = 0;
							break; // 숫자를 찾았으면 내부 루프를 빠져나옴
						}
					}
				}

				if (callCount >= 12) {
					if (checkBingo(bingoBoard) >= 3) {
						System.out.println(callCount);
						return;
					}
				}
			}
		}
	}
}