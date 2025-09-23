import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] start;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 백준
		// 14503. 로봇 청소기

		// N x M 직사각형의 방을 청소
		// 동서남북 중 하나의 방향을 바라봄
		// r, c 로 나타낼 수 있고
		// (0, 0) ~ (N-1 ,M-1)

		// 1. 현재 칸이 청소 되지 않았다면 청소 함
		// 2. 현재 칸의 주변 4칸이 모두 청소됐다면
		// 2-1. 바라보는 방향을 유지한채 한칸 후진 후 1번
		// 2-2. 후진이 불가능(뒤가 벽)하면 작동을 멈춤
		// 3. 주변 4칸 중 청소 안된 장소가 있는 경우
		// 3-1. 반시계 방향으로 90도 회전
		// 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한칸 전진
		// 3-3. 1번으로 돌아감

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		start = new int[3];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			start[i] = Integer.parseInt(st.nextToken());
		}
		// 0 시작 r
		// 1 시작 c
		// 2 시작 방향
		// 방향 - 0북 / 1동 / 2남 / 3서
		cnt = 0; // 청소한 칸을 셀 변수
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println(cnt);

	}

	static int[] dr = { -1, 0, 1, 0 }; // 기본 로봇 방향벡터 idx / 북 동 남 서
	static int[] dc = { 0, 1, 0, -1 };

	static int[] ddr = { -1, 0, 1, 0 }; // 로봇이 쓰레기를 탐색하는 반시계 로직
	static int[] ddc = { 0, -1, 0, 1 };

	private static void bfs() {
		int r = start[0];
		int c = start[1];
		int dir = start[2];

		while (true) {
			// 1. 현재 칸이 청소되지 않은 경우, 현재 칸을 청소한다.
			if (map[r][c] == 0) {
				cnt++;
				map[r][c] = 2; // 청소한 칸은 2로 표시 (벽과 구분)
			}

			boolean found = false; // 4방향 중 청소할 곳을 찾았는지 여부

			// 3. 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인

			for (int i = 0; i < 4; i++) {
				// 3-1. 반시계 방향으로 90도 회전
				dir = (dir + 3) % 4; // 반시계 회전: (dir - 1 + 4) % 4 와 동일
				int nr = r + dr[dir];
				int nc = c + dc[dir];

				// 3-2. 회전 후, 앞쪽 칸이 청소되지 않은 빈 칸인 경우
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
					r = nr;
					c = nc;
					found = true;
					break; // 1번으로 회귀 }
				}
			}
			// 4방향 탐색 후 청소할 곳을 찾았다면(found == true), 넘어감
			if (found) {
				continue;
			}

			// 2. 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우 (found == false)
			int backDir = (dir + 2) % 4; // 후진 방향
			int br = r + dr[backDir];
			int bc = c + dc[backDir];

			// 후진할 곳이 벽이 아니라면 후진
			if (br >= 0 && br < N && bc >= 0 && bc < M && map[br][bc] != 1) {
				r = br;
				c = bc;
			} else {
				// 후진 불가하면 탈출
				break;

			}
		}
	}
}
