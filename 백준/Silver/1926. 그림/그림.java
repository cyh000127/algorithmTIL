import java.io.*;
import java.util.*;

public class Main {

	// 전역 변수로 cnt를 다시 사용합니다.
	static int M, N, cnt, aa;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[M][N];

		int cnt = 0;
		aa = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(aa);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { i, j });
		visited[i][j] = true;

		int ans = 1;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];

			aa = Math.max(ans, aa);

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
					ans++;
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
	}
}