import java.io.*;
import java.util.*;

public class Main {
	// 상하좌우 이동을 위한 배열
	static int[] dr = { -1, 1, 0, 0 }; // row
	static int[] dc = { 0, 0, -1, 1 }; // column
	static int N;
	static boolean[][] visited;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		// 지도 정보 입력받기
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0'; 
			}
		}

		// 각 단지의 집 개수를 저장할 리스트
		List<Integer> list = new ArrayList<>();

		// 전체 지도를 순회
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 아직 방문하지 않은 집을 찾으면 새로운 단지 탐색 시작
				if (map[i][j] == 1 && !visited[i][j]) {
					list.add(bfs(i, j));
				}
			}
		}

		// 결과 출력
		Collections.sort(list); // 단지 내 집의 수를 오름차순으로 정렬
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n"); // 총 단지수
		for (int size : list) {
			sb.append(size).append("\n");
		}
		System.out.print(sb);
	}

	// BFS 메소드: 한 단지를 탐색하고 그 크기를 반환
	private static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		
		// 시작점 큐에 추가 및 방문 처리
		queue.add(new int[]{r, c});
		visited[r][c] = true;
		int houseCount = 1; // 시작점도 개수에 포함

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curR = current[0];
			int curC = current[1];

			// 현재 위치에서 상하좌우 탐색
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];

				// 1. 지도 범위를 벗어나는지 확인
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}
				
				// 2. 이미 방문했거나 집이 아닌 경우 무시
				if (visited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}

				// 새로운 집 발견! 큐에 추가하고 방문 처리
				queue.add(new int[]{nr, nc});
				visited[nr][nc] = true;
				houseCount++;
			}
		}
		return houseCount;
	}
}