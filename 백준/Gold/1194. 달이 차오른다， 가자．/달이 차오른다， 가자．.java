import java.util.*;
import java.io.*;

class State {
	int r, c, dist, keys;

	public State(int x, int y, int dist, int keys) {
		super();
		this.r = x;
		this.c = y;
		this.dist = dist;
		this.keys = keys;
	}
}

public class Main {
	static char[][] map;
	static boolean[][][] visited; // 3차원 배열
	static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 1194. 달이 차오른다, 가자.

		// 직사각형의 미로
		// . |언제나 이동 가능
		// # |절대 이동 불가 (벽)
		// abcdef | 언제나 이동가능 (열쇠 존재)
		// ABCDEF | 열쇠가 있을때만 이동 가능 (문)
		// 0 | 민식이 현재 위치
		// 1 | 도착지점

		// 최소 횟수 구하기

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		// 시작 위치 저장
		int[] start = new int[2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char s = str.charAt(j);
				map[i][j] = s;
				if (s == '0') {
					start[0] = i;
					start[1] = j;
					map[i][j] = '.';
				}
			}
		}

		visited = new boolean[N][M][64];

		System.out.println(bfs(start));
	}

	private static int bfs(int[] start) {
		Queue<State> q = new ArrayDeque<>();

		// 시작: (r, c, 거리 0, 열쇠 없음 0)
		q.add(new State(start[0], start[1], 0, 0));
		visited[start[0]][start[1]][0] = true;

		while (!q.isEmpty()) {
			State curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int dist = curr.dist;
			int keys = curr.keys;

			if (map[r][c] == '1') {
				return dist;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '#')
					continue;

				char nextLoc = map[nr][nc];

				if (nextLoc == '.' || nextLoc == '1') {
					if (!visited[nr][nc][keys]) {
						visited[nr][nc][keys] = true;
						q.add(new State(nr, nc, dist + 1, keys));
					}
				}
				// 열쇠
				else if (nextLoc >= 'a' && nextLoc <= 'f') {
					int newkeys = keys | (1 << (nextLoc - 'a'));

					if (!visited[nr][nc][newkeys]) {
						visited[nr][nc][newkeys] = true;
						q.add(new State(nr, nc, dist + 1, newkeys));
					}
				} else if (nextLoc >= 'A' && nextLoc <= 'F') {
					int doorBit = 1 << (nextLoc - 'A');
					if ((keys & doorBit) > 0) {
						if (!visited[nr][nc][keys]) {
							visited[nr][nc][keys] = true;
							q.add(new State(nr, nc, dist + 1, keys));
						}
					}
				}
			}
		}

		return -1;
	}
}