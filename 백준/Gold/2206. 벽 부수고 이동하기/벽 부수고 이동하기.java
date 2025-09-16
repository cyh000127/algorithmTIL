import java.util.*;
import java.io.*;

public class Main {
	static int N, M, ans;
	static int[][] arr;
	static boolean[][][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 백준
		// 2206. 벽 부수고 이동하기

		// N x M 맵
		// 1 벽 // 0 길
		// 1번까지 벽 부술 수 있음

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		visited = new boolean[N][M][2];

		ans = -1;

		visited[0][0][0] = true;
		findRoot(0, 0);

		if (N == M && N == 1)
			ans = 1;
		System.out.println(ans);

	}

	private static void findRoot(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c, 0, 1 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int curR = curr[0]; // R
			int curC = curr[1]; // C
			int breakTheWall = curr[2]; // 벽을 부신적이 있을까?
			int cnt = curr[3];
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];

				if (nr >= 0 && nc >= 0 && nc < M && nr < N) {
					if (nr == N - 1 && nc == M - 1) { // 끝에 도달
						ans = cnt + 1;
						return;
					}

					if (arr[nr][nc] == 0 && !visited[nr][nc][breakTheWall]) {
						visited[nr][nc][breakTheWall] = true;

						q.add(new int[] { nr, nc, breakTheWall, cnt + 1 });
					}

					else if (arr[nr][nc] == 1 && breakTheWall == 0 && !visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						q.add(new int[] { nr, nc, 1, cnt + 1 });

					}
				}

			}
		}
	}
}