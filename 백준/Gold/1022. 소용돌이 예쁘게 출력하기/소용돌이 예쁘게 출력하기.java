import java.util.*;
import java.io.*;

public class Main {

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		// 백준
		// 1022. 소용돌이 예쁘게 출력하기

		// r1 c1 r2 c2가 입력으로 주어진다.
		// r1, c1이 가장 왼쪽 위
		// r2, c2는 가장 오른쪽 아래

		// r1부터 r2까지 차례로 출력함
		// 공백으로 구분
		// 모든 행은 같은 길이를 최소로 가져야함 ( 백의 자리면 기본 자리가 3칸)
		// 왼쪽부터 공백을 넣음

		// 네 정수 r1 c1 r2 c2가 주어짐

		// r2- r1 + 1 개의 줄에 소용돌이를 출력

		int rowSize = r2 - r1 + 1;
		int colSize = c2 - c1 + 1;
		int[][] map = new int[rowSize][colSize];

		int totalCells = rowSize * colSize; // 채워야 할 총 칸 수
		int filledCells = 0; // 현재까지 채운 칸 수
		int maxVal = 0;

		int r = 0, c = 0; // 현재 좌표 (중심 0,0)
		int num = 1; // 현재 값
		int dir = 0; // 현재 방향 (0:R, 1:U, 2:L, 3:D)
		int moveLen = 1; // 현재 방향으로 이동할 칸 수
		int moveCount = 0; // 방향 전환 카운트 

		while (filledCells < totalCells) {
			// moveLen 만큼 현재 방향으로 이동
			for (int i = 0; i < moveLen; i++) {

				// 범위 확인
				if (r >= r1 && r <= r2 && c >= c1 && c <= c2) {
					// map에 값 저장
					map[r - r1][c - c1] = num;
					filledCells++; // 채운 칸 수 증가
					maxVal = Math.max(maxVal, num); // 최대값 갱신
				}

				if (num == 10001 * 10001) {
					break;
				}

				// 다음 칸으로 이동
				r += dr[dir];
				c += dc[dir];
				num++;
			}

			if (filledCells == totalCells)
				break; // 다 채웠으면 즉시 종료

			// 이동 길이 갱신
			dir = (dir + 1) % 4; // 방향 전환
			moveCount++;
			if (moveCount == 2) {
				moveLen++; // 이동 길이를 1 증가
				moveCount = 0; // 카운트 리셋
			}
		}

		// 출력
		int maxLen = String.valueOf(maxVal).length(); // 최대값의 자릿수
		String format = "%" + maxLen + "d "; // 출력 형식

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				sb.append(String.format(format, map[i][j]));
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}