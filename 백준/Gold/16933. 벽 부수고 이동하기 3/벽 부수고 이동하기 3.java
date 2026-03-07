import java.util.*;
import java.io.*;

/**
 * 16933 벽 부수고 이동하기 3
 */
public class Main {
	static int n, m, k;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 낮, 밤 번갈아 생김
		// 낮에는 벽을 K번 까지 뿌실 수 잇음
		// 최단 거리 구하셈
		// 불가능 할 때에는 -1
		// 이동할 때마다 낮,밤이 변함
		// 같은 칸에 머무는 것도 가능 ( 밤 -> 낮 바꾸기 위해 )
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		// 0,0부터 n-1, m-1 까지 가는 최단거리 구해
		System.out.println(bfs(0));

	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static int bfs(int moveCnt) {
		Queue<int[]> q = new LinkedList<>();

		// 벽을 얼마나 부섰는지 까지 배열에 같이 들어가야함
		boolean[][][] visited = new boolean[n][m][k + 1];

		q.add(new int[] { 0, 0, 1, 0, 0 });
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			int cnt = tmp[2];
			int wallCnt = tmp[3];

			// 0일때 낮, 1일때 밤
			int day = tmp[4];

			// 탈출 조건
			if (r == n - 1 && c == m - 1) {
				return cnt;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;

				// 이동할 곳이 빈칸일 때
				if (map[nr][nc] == 0) {
					if (!visited[nr][nc][wallCnt]) { // 현재 부순 벽 개수 상태로 방문 체크
						visited[nr][nc][wallCnt] = true;
						q.add(new int[] { nr, nc, cnt + 1, wallCnt, 1 - day });
					}
				}
				// 이동할 곳이 벽일 때
				else {
					if (wallCnt < k && !visited[nr][nc][wallCnt + 1]) { // 다음 부순 벽 개수 상태로 체크
						if (day == 0) { // 낮일 때만 부숨
							visited[nr][nc][wallCnt + 1] = true;
							q.add(new int[] { nr, nc, cnt + 1, wallCnt + 1, 1 - day });
						} else { // 밤이면 제자리
							q.add(new int[] { r, c, cnt + 1, wallCnt, 0 });
						}
					}
				}
			}
		}
		return -1;
	}
}
