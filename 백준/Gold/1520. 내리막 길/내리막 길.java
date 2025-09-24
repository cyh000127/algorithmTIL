import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dp; // 경로의 수를 저장할 DP 배열 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // r
		M = Integer.parseInt(st.nextToken()); // c

		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; // -1로 초기화하여 아직 계산되지 않았음을 표시
			}
		}

		System.out.println(dfs(0, 0));
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	private static int dfs(int r, int c) {
		// 목적지에 도착했다면 1을 반환 (경로 1개 발견)
		if (r == N - 1 && c == M - 1) {
			return 1;
		}


		// 이미 (r, c)에서 목적지까지 가는 경로의 수를 계산했다면
		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		// 현재 위치에서 시작하는 경로의 수를 0으로 초기화
		dp[r][c] = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nc >= 0 && nc < M && nr < N && map[nr][nc] < map[r][c]) {
				// (nr, nc)에서 목적지까지 가는 경로의 수를 누적해서 더해줌
				dp[r][c] += dfs(nr, nc);
			}
		}

		// (r, c)에서 목적지까지 가는 모든 경로의 수를 계산했으므로 반환
		return dp[r][c];
	}
}