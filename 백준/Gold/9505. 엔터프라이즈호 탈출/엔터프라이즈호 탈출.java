import java.util.*;
import java.io.*;

/**
 * 9505 엔터프라이즈호 탈출
 */
public class Main {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 탈출 루트 찾기
		// 각 클래스의 클링온 전투선을 무력화 시키는데에 걸리는 시간

		// 경로의 모든 클링온 전투선을 무력화 시키며 가장자리로 탈출하도록 하자
		// 입력된 평면의 단위 사각형은 꼭짓점이 아닌 가장자리로만 연결됨

		// 테케 T
		// 전투선 개수 k
		// 평면의 폭 w
		// 높이 h

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			// 전투선의 클래스 이름은 알파벳 대문자 ( "E" 제외 -> E는 나 자신 )

			int[] warship = new int[26];
			// 클래스 이름 + 무력화에 걸리는 시간
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int classNum = st.nextToken().charAt(0) - 'A';
				int time = Integer.parseInt(st.nextToken());
				warship[classNum] = time;
			}

			// 시간제한이 무려 10초짜리 문제.
			int[][] map = new int[h][w];
			int enterprise = 0;

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					int classNum = str.charAt(j) - 'A';

					map[i][j] = classNum;

					// 위치가 E 즉, 엔터프라이즈 호 일때
					if (classNum == 4) {
						enterprise = i * w + j;
					}
				}
			}
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(new int[] { enterprise / w, enterprise % w }, 0));

			int[][] dist = new int[h][w];
			for (int i = 0; i < h; i++)
				Arrays.fill(dist[i], INF);

			dist[enterprise / w][enterprise % w] = 0;

			int minTime = INF;

			while (!pq.isEmpty()) {
				Node curr = pq.poll();

				int[] loc = curr.end;
				int cost = curr.cost;

				// 지금 pq에서 뽑은게 한참전에 계산한 것일 수 있음
				if (cost != dist[loc[0]][loc[1]]) {
					continue;
				}

				// 탈출조건
				if (loc[0] == 0 || loc[0] == h - 1 || loc[1] == 0 || loc[1] == w - 1) {
					minTime = Math.min(minTime, cost);
				}

				for (int i = 0; i < 4; i++) {
					int nr = loc[0] + dr[i];
					int nc = loc[1] + dc[i];

					if (nr < h && nr >= 0 && nc < w && nc >= 0) {
						int nextCost = cost + warship[map[nr][nc]];
						if (dist[nr][nc] > nextCost) {
							dist[nr][nc] = nextCost;
							pq.add(new Node(new int[] { nr, nc }, nextCost));
						}
					}
				}
			}
			sb.append(minTime).append("\n");
		}
		System.out.println(sb.toString().trim());

	}

	static class Node implements Comparable<Node> {
		int[] end;
		int cost;

		public Node(int[] end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}
}