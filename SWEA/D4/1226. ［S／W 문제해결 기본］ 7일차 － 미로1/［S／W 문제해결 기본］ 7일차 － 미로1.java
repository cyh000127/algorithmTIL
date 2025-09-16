import java.io.*;
import java.util.*;

public class Solution {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // 상 , 우 , 하, 좌 시계방향

	static int[][] map;
	static StringBuilder sb;
	static int[] start;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = 10;
		while (T-- > 0) {
			int test = Integer.parseInt(br.readLine());
			sb.append("#").append(test).append(" ");
			/*
			 * 미로 1 16 * 16 행렬의 미로 0 = 길 1 = 벽 2 = 시작 3 = 도착 도착 가능, 도착 불가를 찾는 문제
			 */

			map = new int[16][16];

			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
					if (map[i][j] == 2) {
						start = new int[] { i, j };
					}
				}
			}
			visited = new boolean[16][16];
			mazeRunner();
		}
		System.out.println(sb.toString().trim());
	}

	private static void mazeRunner() {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { start[0], start[1] });
		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nc >= 0 && nc < 16 && nr < 16 && !visited[nr][nc] && map[nr][nc] != 1) {
					if (map[nr][nc] == 3) {
						sb.append(1).append("\n");
						return;
					}

					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
		
		// while문 종료시까지 return이 되지 않았다면
		sb.append(0).append("\n");
		

	}
}
