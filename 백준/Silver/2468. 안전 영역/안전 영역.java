import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 2468 안전 영역
		// 지도에 비가올거야
		// 비가 많이 내렸을 때 물에 잠기지 않는 안전 영역이 최대 몇개인지

		// 덩어리로 (모든면이 물이 될 떄 까지 ) 계산
		// 안전 영역 계산 프로그램을 계산해라
		// 최대 값을 계산해야함

		// 구현은 가능한데,, 이게 시간 제한에 안걸리려나
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		// 지도 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		int maxCnt = 0;
		// 이제 가장 안전영역이 많을때를 계산해보자
		// 최대 높이는 1이상 100이하니까
		// 비가 안올 수 도 있음
		for (int i = 0; i < 100; i++) {
			int cnt = findSafetyZone(i);
			if (cnt == 0)
				break; // 모두 잠겼다는 의미임

			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}

	private static int findSafetyZone(int rainFall) {
		boolean[][] visited = new boolean[N][N];
		int count = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (rainFall < map[r][c] && !visited[r][c]) { // 잠기지 않았고 방문하지 않은곳을 찾았다면
					count++;
					bfs(r, c, rainFall, visited);
				}

			}
		}
		return count;
	}

	private static void bfs(int r, int c, int rainFall, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int curR = curr[0];
			int curC = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc] > rainFall) {
					// 붙어있는 안전영역을 발견했다면
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
	}

}
