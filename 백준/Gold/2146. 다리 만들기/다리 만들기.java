import java.io.*;
import java.util.*;

import javax.swing.text.AbstractDocument.BranchElement;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int[][] island, map;
	static int M, num;

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		M = Integer.parseInt(br.readLine()); // 지도 크기

		map = new int[M][M];

		// 백준
		// 2146. 다리 만들기

		// 섬끼리 연결하는 가장 최소 비용의 다리 건설

		// 1. 지도를 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2. visited를 설정 해야하는데

		// a섬에서 출발해서 a섬으로 도착하는 경우를 막기 위해
		// 섬마다 체크를 해줘야함
		visited = new boolean[M][M];
		island = new int[M][M];
		num = 1;
		// bfs를 통해 섬마다의 넘버링을 했음
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j])
					bfs(i, j);
			}
		}

//		 디버그용 코드
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(island[i][j] + " ");
//			}
//			System.out.println();
//		}

		visited = new boolean[M][M]; // visited배열 다시 선언

		// 3. 이제 해안가를 찾아줘야 함(바다와 맞닿은 위치 )
		// 찾아서 모두 큐에 넣기
		Queue<int[]> q = new LinkedList<>();

		// 해안가를 찾아서 모두 큐에 집어넣기
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				// 해안가 찾기
				for (int d = 0; d < 4; d++) {
					int nr = dr[d] + i;
					int nc = dc[d] + j;
					//
					if (island[i][j] != 0 && nr >= 0 && nc >= 0 && nr < M && nc < M && island[nr][nc] == 0
							&& !visited[nr][nc]) {
						visited[i][j] = true;
						q.add(new int[] { i, j, 0, island[i][j] });
						break;
					}

				}
			}
		}

		// 다리 짓기
		int shortestBridge = bridge(q);

		System.out.println(shortestBridge);
	}

	// 다리 건설 로직
	private static int bridge(Queue<int[]> q) {
	    int[][] dist = new int[M][M]; // 각 지점까지의 다리 길이를 저장할 배열
	    int min = Integer.MAX_VALUE;

	    while (!q.isEmpty()) {
	        int[] curr = q.poll();
	        int r = curr[0];
	        int c = curr[1];
	        // 큐에 있던 cnt와 startIsland는 이제 dist와 island 배열을 통해 관리되므로 필요 없음

	        for (int d = 0; d < 4; d++) {
	            int nr = r + dr[d];
	            int nc = c + dc[d];

	            if (nr < 0 || nc < 0 || nr >= M || nc >= M) continue;

	            // 내가 확장하려는 곳이 다른 섬의 확장 영역과 만났을 때
	            if (island[nr][nc] != 0 && island[nr][nc] != island[r][c]) {
	                // 다리 길이 = 내 쪽 다리 길이 + 상대편 쪽 다리 길이
	                int bridgeLength = dist[r][c] + dist[nr][nc];
	                min = Math.min(min, bridgeLength);
	            }

	            // 아직 아무도 방문하지 않은 바다일 때
	            if (island[nr][nc] == 0) {
	                island[nr][nc] = island[r][c]; // 내 섬 번호로 영역 표시
	                dist[nr][nc] = dist[r][c] + 1; // 거리 1 증가
	                q.add(new int[]{nr, nc});
	            }
	        }
	    }
	    return min;
	}

	// 섬 넘버링을 위한 bfs 메서드
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { i, j });
		visited[i][j] = true;
		island[i][j] = num;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nc >= 0 && nr < M && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					island[nr][nc] = num;
					q.add(new int[] { nr, nc });
				}
			}
		}
		num++;// 다음 검색을 위해 num++;
	}
}