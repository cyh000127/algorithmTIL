import java.util.*;
import java.io.*;

/*
 * 10217 KCM Travel
 */
public class Main {

	static class Node implements Comparable<Node> {
		int end;
		int cost;
		int duration;

		public Node(int e, int c, int d) {
			end = e;
			cost = c;
			duration = d;
		}

		// 소요시간을 기준으로 정렬
		// 하지만 지원비용도 조건에 있기 때문에 2순위 정렬은 cost
		@Override
		public int compareTo(Node o) {
			if (this.duration == o.duration) {
				return this.cost - o.cost;
			}
			return this.duration - o.duration;
		}
	}

	static int n, m, k;

	static List<List<Node>> li;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// T무조건 1이니 하나 버리기
		br.readLine();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 공항 수
		m = Integer.parseInt(st.nextToken()); // 지원 비용
		k = Integer.parseInt(st.nextToken()); // 티켓 수

		// k가 0일 수 있음
		if (k == 0) {
			System.out.println("Poor KCM");
			return;
		}

		li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 출발
			int v = Integer.parseInt(st.nextToken()); // 도착
			int c = Integer.parseInt(st.nextToken()); // 비용
			int d = Integer.parseInt(st.nextToken()); // 소요시간

			li.get(u).add(new Node(v, c, d));
		}

		// 무조건 1에서 n까지 가야함
		int ans = dijkstra();
		if (ans == INF)
			sb.append("Poor KCM");
		else
			sb.append(ans);

		System.out.println(sb);
	}

	static final int INF = 10_000_001;

	private static int dijkstra() {
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[1][0] = 0;

		for (int cost = 0; cost <= m; cost++) {
			for (int now = 1; now <= n; now++) {
				if (dp[now][cost] == INF)
					continue;

				for (Node next : li.get(now)) {
					int nextCost = cost + next.cost;
					int nextTime = dp[now][cost] + next.duration;

					if (nextCost > m)
						continue;
					if (dp[next.end][nextCost] > nextTime) {
						dp[next.end][nextCost] = nextTime;
					}
				}
			}
		}

		int ans = INF;
		for (int cost = 0; cost <= m; cost++) {
			ans = Math.min(ans, dp[n][cost]);
		}
		return ans;
	}
}
