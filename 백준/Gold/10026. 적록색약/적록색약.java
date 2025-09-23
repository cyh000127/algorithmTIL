import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 백준
		// 10026. 적록색약

		// 적록색약은 빨, 초 차이 모름
		// N x N 그리드에 R,G,B가 있음
		// 같은 색상이 상하좌우로 인접해 있다면 같은 구역에 속한다

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int cnt = 0;
		// 색약이 아닌 친구가 보는 세상은 어떤걸까?
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					q.add(new int[] { i, j, 0 });
					bfs(q);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(" ");

		visited = new boolean[N][N]; // 방문배열 초기화
		cnt = 0; // 카운트 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					q.add(new int[] { i, j, 1 });
					bfs(q);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb.toString().trim());
		
	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	private static void bfs(Queue<int[]> q) {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int eye = curr[2]; // 색약인지 판단
			char color = map[r][c];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc] == color && eye == 0) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc, 0 });
				}

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && eye == 1) {
					if ((map[nr][nc] == 'R' || map[nr][nc] == 'G') && (color == 'R' || color == 'G')) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, 1 });
					} else if (map[nr][nc] == color) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, 1 });
					}
				}

			}
		}

	}
}
