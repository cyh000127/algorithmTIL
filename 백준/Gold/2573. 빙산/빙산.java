import java.util.*;
import java.io.*;

public class Main {
	static int r, c;
	static int[][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 백준
		// 2573. 빙산

		// 2차원 배열위의 빙산이 녹고 있다.
		// 0은 바다 , 0 이외의 수는 빙산
		// 바다와 맞닿은 빙산은 4방향으로 바다에 붙어있는 만큼 녹는다.
		// 두 덩어리 이상으로 분리되는 최소 년수를 구하여라
		// 완전 소멸이 먼저 된다면 0

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (true) {
			// 1. 빙산 덩어리 개수 확인
			int islandCount = countIslands();

			// 2. 종료 조건 검사
			if (islandCount >= 2) {
				// 두 덩어리 이상으로 분리되면 해당 년도 출력 후 종료
				System.out.println(year);
				break;
			} else if (islandCount == 0) {
				// 두 덩어리로 분리되기 전에 모두 녹았으면 0 출력 후 종료
				System.out.println(0);
				break;
			}

			// 3. 1년의 시간 흐름 (빙산 녹이기)
			melt();
			year++;
		}
	}

	// 빙산을 녹이는 메서드
	private static void melt() {
		// 모든 빙산이 동시에 녹아야 하므로, 얼마나 녹을지 저장할 별도의 배열이 필요
		int[][] meltMap = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) { // 현재 위치가 빙산인 경우
					int seaCount = 0;
					// 4방향 탐색하여 주변 바다(0)의 개수를 센다
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 0) {
							seaCount++;
						}
					}
					meltMap[i][j] = seaCount;
				}
			}
		}

		// 빙산 녹이기 
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] -= meltMap[i][j];
				if (map[i][j] < 0) {
					map[i][j] = 0; // 높이는 0 미만이 될 수 없음
				}
			}
		}
	}

	// 빙산 덩어리의 개수를 세는 메서드
	private static int countIslands() {
		boolean[][] visited = new boolean[r][c];
		int count = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				// 빙산이면서 아직 방문하지 않은 지점에서만 탐색 시작
				if (map[i][j] > 0 && !visited[i][j]) {
					// 새로운 덩어리를 찾았으므로 count 증가
					count++;
					// 해당 덩어리와 연결된 모든 빙산을 방문 처리
					bfsForCount(i, j, visited);
				}
			}
		}
		return count;
	}

	// 한 덩어리에 연결된 모든 빙산을 찾는 BFS
	private static void bfsForCount(int startR, int startC, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { startR, startC });
		visited[startR][startC] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
					// 다음 위치가 방문하지 않은 빙산이라면 큐에 추가하고 방문 처리
					if (map[nr][nc] > 0 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc });
					}
				}
			}
		}
	}
}
