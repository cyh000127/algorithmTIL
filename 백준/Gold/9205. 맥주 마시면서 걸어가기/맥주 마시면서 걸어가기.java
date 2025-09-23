import java.util.*;
import java.io.*;

public class Main {
	static int n;

	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 백준
		// 9205.맥주 마시면서 걸어가기

		// 맥주 한 박스 = 20병
		// 50 미터당 1병
		// 편의점에서 빈병을 버리고 새로 살 수 있음 ( 다시 20 병까지 충전 가능 )
		// 편의점에서 나올때 하나 먹으면서 가야함
		// 편의점 - 상근이네 - 펜타포트 락 페스 좌표가 주어짐

		// 테케 T
		// 편의점 개수 n
		// 락페스 좌표 (x, y)
		// 송도는 직사각형 (거리는 x차이 + y차이 (= 맨해튼))

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());

			map = new int[n + 2][2]; // 0 상근 / n+1 편의점

			st = new StringTokenizer(br.readLine());
			map[0][0] = Integer.parseInt(st.nextToken());
			map[0][1] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());

				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			map[n + 1][0] = Integer.parseInt(st.nextToken());
			map[n + 1][1] = Integer.parseInt(st.nextToken());

			visited = new boolean[n + 2];
			// 상근이네 0
			// 페스 n+1

			bfs();
		}
	}

	// fes, conv, sang
	private static void bfs() {
		// 50미터당 한병이니까 거리가 1000이상 차이나면 의미 없음
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { map[0][0], map[0][1], 20 }); // 시작노드는 상근이 집

		visited[0] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			int beer = curr[2];

			for (int i = 1; i <= n + 1; i++) {
				int dis = Math.abs(x - map[i][0]) + Math.abs(y - map[i][1]);
				if (!visited[i] && dis <= beer * 50) {
					if (i == n + 1) { // 종료 조건
						System.out.println("happy");
						return;
					} else { // 집과 페스를 빼면 전부 편의점임
						visited[i] = true;
						q.add(new int[] { map[i][0], map[i][1], 20 });
					}
				}
			}
		}
		System.out.println("sad");
	}
}
