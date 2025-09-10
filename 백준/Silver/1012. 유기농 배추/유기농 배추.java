import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static boolean[][] visited;
	static int M, N;
	static int[][] arr;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		// 테케
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			int K = Integer.parseInt(st.nextToken()); // 배추의 위치 개수
			cnt = 0;

			arr = new int[M][N]; // 주어지는 좌표 값이 x,y이기 떄문에 M,N을 뒤집어서 사용
			visited = new boolean[M][N]; // 똑같이 M,N 으로 선언
			// 0,0부터 시작이기 때문에 +1 안해줘도 됨

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[a][b] = 1;

			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
					
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nr = x + dr[d];
			int nc = y + dc[d];

			if (nr < 0 || nr >= M || nc < 0 || nc >= N)
				continue;
			else if (!visited[nr][nc] && arr[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}

	}
}
