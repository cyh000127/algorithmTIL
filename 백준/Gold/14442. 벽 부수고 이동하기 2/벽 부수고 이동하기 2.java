import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][][] visited;
	static int r, c, b;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		// 1x1 맵 특수 케이스 처리
		if (r == 1 && c == 1) {
			return 1;
		}

		visited = new boolean[r][c][b + 1];
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 0, 0, 0, 1 }); // {r, c, 부순 벽, 거리}
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currR = curr[0];
			int currC = curr[1];
			int bwall = curr[2];
			int move = curr[3];

			for (int d = 0; d < 4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];

			
				if (nr < 0 || nc < 0 || nr >= r || nc >= c)
					continue;

				// 다음이 길(0)인 경우
				if (map[nr][nc] == 0 && !visited[nr][nc][bwall]) {
					if (nr == r - 1 && nc == c - 1)
						return move + 1; // 도착!

					visited[nr][nc][bwall] = true;
					q.add(new int[] { nr, nc, bwall, move + 1 });
				}
				// 다음이 벽(1)이고 부술 수 있는 경우
				else if (map[nr][nc] == 1 && bwall < b && !visited[nr][nc][bwall + 1]) {
					if (nr == r - 1 && nc == c - 1)
						return move + 1; // 도착!

					visited[nr][nc][bwall + 1] = true;
					q.add(new int[] { nr, nc, bwall + 1, move + 1 });
				}
			}
		}
		return -1;
	}
}