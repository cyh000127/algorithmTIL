import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static boolean[][] visited;

	static int cnt, N, M;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		// 1 - 이동할 수 있는 칸
		// 0 - 이동할 수 없는 칸
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];

		arr = new String[N];
		cnt = Integer.MAX_VALUE;
		// 문제에서 i,j는 1부터 시작이나, charAt을 쓸거기 떄문에 0부터 시작으로 조정
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		bfs(0, 0);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c, 1 });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int nowr = current[0];
			int nowc = current[1];
			int distance = current[2];

			if (nowr == N - 1 && nowc == M - 1) {
				System.out.println(distance);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = nowr + dr[d];
				int nc = nowc + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr].charAt(nc) == '1'&& !visited[nr][nc]) {
					// 범위안에 있고 길이라면
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc, distance + 1 });
				}
			}
		}
	}
}
