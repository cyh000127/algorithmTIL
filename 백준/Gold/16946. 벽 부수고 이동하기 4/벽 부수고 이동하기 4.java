import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int[][] map, area;
	static int N, M, cnt;
	static boolean[][] visited;
	static List<int[]> areaExtent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 1. 일단 배열을 받고
		// 2. 배열의 0 의 크기를 재기
		// 3. 벽을 조사해서 벽과 맞닿은 0의 크기를 모두 조사
		// 4. 벽과 길을 모아놓는 배열과 area 배열을 따로 놓기

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M]; // 지도
		visited = new boolean[N][M]; // 방문여부
		area = new int[N][M]; // bfs 후 결과를 담을 area 배열

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0'; // Char -> int로 저장
			}
		}
		areaExtent = new ArrayList<>();
		bfs();

////		// 디버그용 코드
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(area[i][j] + " ");
//			}
//			System.out.println();
//		}
//		for (int[] e : areaExtent) {
//			System.out.println(e[0] + " 넓이 : " + e[1]);
//		}

		// 이제 각 벽을 허물었을때의 넓이를 구해보자
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					HashSet<Integer> set = new HashSet<>();
					for (int d = 0; d < 4; d++) {
						int nr = dr[d] + i;
						int nc = dc[d] + j;
						if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
							set.add(area[nr][nc]);
						}
					}
					for (int a : set) {
						map[i][j] += areaExtent.get(a - 1)[1]; // 벽의 사방향을 조사한 후 맞닿은 area의 넓이를 더함
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]%10);
			}
			System.out.println();
		}
	}

	// 처음 주어진 지도 map
	// 그 map에서 bfs를 통해 구역번호를 나눈 area
	// 그 area의 넓이를 담는 areaExtent
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		cnt = 1; // 구역 번호
		int extent = 1; // 넓이

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) { // 길이고 방문한적 없다면
					q.add(new int[] { i, j });
					visited[i][j] = true;
					area[i][j] = cnt;

					while (!q.isEmpty()) {
						int[] e = q.poll();
						for (int d = 0; d < 4; d++) {
							int nr = dr[d] + e[0];
							int nc = dc[d] + e[1];
							if (nr < 0 || nr >= N || nc < 0 || nc >= M)
								continue;
							if (!visited[nr][nc] && map[nr][nc] == 0) {
								// 나아갈 곳이 방문한적 없고 이어져 있다면
								visited[nr][nc] = true;
								area[nr][nc] = cnt;
								extent++;
								q.add(new int[] { nr, nc });
								// area에 구역 번호를 부여한 후
								// 구역번호에 넓이를 저장할 거임
							}
						}
					}
					areaExtent.add(new int[] { cnt, extent }); // 해당 구역번호의 넓이를 저장
					extent = 1;

					cnt++; // 한 구역을 찾은 후 cnt ++;
//					System.out.println(cnt);
				}
			}
		}

	}
}