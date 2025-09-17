import java.io.*;
import java.util.*;

public class Main {
	static int R, C, cnt;
	static char[][] map;
	static int[][] burning;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 불의 시작점이 여러 개일 수 있으므로 큐를 사용
		Queue<int[]> fireQueue = new LinkedList<>();
		int[] start = new int[2];

		map = new char[R][C];
		burning = new int[R][C];
		
		// burning 배열을 최대값으로 초기화 (불이 도달하지 않는 곳 표현)
		for (int i = 0; i < R; i++) {
			Arrays.fill(burning[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'J') {
					start[0] = i;
					start[1] = j;
				}
				if (map[i][j] == 'F') {
					// 모든 불의 시작점을 큐에 추가하고, 시간은 0으로 설정
					fireQueue.add(new int[] { i, j, 0 });
					burning[i][j] = 0;
				}
			}
		}

		visited = new boolean[R][C];
		cnt = -1; // 초기값은 실패(-1)로 설정

		// 1. 불 먼저 번지게 함
		fire(fireQueue);

		// 2. 지훈이 이동 시작
		bfs(start);
		
		if (cnt == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(cnt);
		}
	}

	// 불의 확산을 계산하는 BFS
	private static void fire(Queue<int[]> q) {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int time = curr[2];

			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + r;
				int nc = dc[d] + c;

				// 배열 범위 내에 있고, 벽이 아니며, 아직 불이 번지지 않은 곳
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '#' && burning[nr][nc] == Integer.MAX_VALUE) {
					burning[nr][nc] = time + 1;
					q.add(new int[] { nr, nc, time + 1 });
				}
			}
		}
	}

	// 지훈이의 탈출 경로를 찾는 BFS
	private static void bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();

		// 지훈이의 시작 위치가 이미 불에 타는 경우 체크
		if (burning[start[0]][start[1]] == 0) {
			cnt = -1;
			return;
		}
		
		q.add(new int[] { start[0], start[1], 0 });
		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int time = curr[2];
			
			// 현재 위치가 가장자리인지 확인하여 탈출 여부 판단
            if (r == 0 || r == R - 1 || c == 0 || c == C - 1) {
                cnt = time + 1;
                return;
            }

			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + r;
				int nc = dc[d] + c;

				// 배열 범위 내에 있고, 방문하지 않았으며, 벽이 아닌 곳
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] != '#') {
					// **수정된 핵심 조건**: 지훈이가 도착하는 시간(time+1)이 불이 오는 시간보다 빨라야 함
					if (burning[nr][nc] > time + 1) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, time + 1 });
					}
				}
			}
		}
	}
}