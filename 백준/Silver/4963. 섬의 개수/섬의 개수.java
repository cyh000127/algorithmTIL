import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0, 1, -1, -1, 1 };
	static int[] dc = { 0, 0, 1, -1, 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 4963. 섬의 개수
		// 대각선도 이동 가능
		// 여러 테스트 케이스가 가능하며, 마지막줄에는 0이 두개 주어진다.

		while (true) {
			String str = br.readLine();
			if (str.equals("0 0"))
				break; // 종료조건
			st = new StringTokenizer(str);
			w = Integer.parseInt(st.nextToken()); // w< 50 // 너비
			h = Integer.parseInt(st.nextToken()); // h< 50 // 높이

			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[h][w];
			// 0은 바다 , 1은 땅
			int result = bfs();

			System.out.println(result);
		}

	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					q.add(new int[] { i, j });
					cnt++;
//					System.out.println(i +" " + j);
					while (!q.isEmpty()) {
						int[] curr = q.poll();

						int curR = curr[0];
						int curC = curr[1];

						for (int d = 0; d < 8; d++) {
							int nr = curR + dr[d];
							int nc = curC + dc[d];

							if (nr >= 0 && nc >= 0 && nr < h && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
								visited[nr][nc] = true;
								q.add(new int[] { nr, nc });
							}
						}
					}
				}
			}
		}
		return cnt;
	}

}
//for(int i =0 ;  i< h; i++) {
//	for(int j = 0 ; j<w; j++) {
//		
//	}
//}
