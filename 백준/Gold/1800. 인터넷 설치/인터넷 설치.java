import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int to, cost;

	public Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}

}

public class Main {
	static List<Edge>[] graph;
	static int N, M, K;
	static int[] dist;
	final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 백준
		// 1800. 인터넷 설치

		// 1부터 N까지의 학생 인터넷선 연결 x
		// P개의 쌍 만이 서로 이어질 수 있음

		// K개의 공짜 케이블
		// 1번은 바로 연결되어있음 (dist[1] = 0)
		// 1번에서 시작해서 N까지 케이블 연결하기
		// 비용은 결국 하나만 냄

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 케이블 개수
		K = Integer.parseInt(st.nextToken()); // 공짜 제공 케이블 개수

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		dist = new int[N + 1];

		int maxCost = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from].add(new Edge(to, cost));
			graph[to].add(new Edge(from, cost));
			maxCost = Math.max(maxCost, cost);
		}

		// 이분 탐색을 통한 최소 비용 계산
		int low = 0;
		int high = maxCost;
		int ans = -1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (dijkstra(mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		System.out.println(ans);

	}

	private static boolean dijkstra(int maxPay) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		Arrays.fill(dist, INF);

		dist[1] = 0; // 1번은 쿠폰 0개로 시작
		pq.add(new Edge(1, 0));

		while (!pq.isEmpty()) {
			Edge nowNode = pq.poll();

			int loc = nowNode.to;
			int couponCount = nowNode.cost;

			if (dist[loc] < couponCount) {
				continue;
			}

			for (Edge e : graph[loc]) {
				int nextLoc = e.to;
				int cableCost = e.cost; // 케이블의 '원래' 비용

				// 최대 지불 금액보다 높으면 쿠폰 사용
				// 최대 지불 금액보다 낮으면 무시 ( 최대 비용 하나만 지불하기 때문 )
				int nextCouponCost = (cableCost > maxPay) ? 1 : 0;

				int totalCoupon = couponCount + nextCouponCost;

				if (dist[nextLoc] > totalCoupon) {
					dist[nextLoc] = totalCoupon;
					pq.add(new Edge(nextLoc, totalCoupon));
				}

			}
		}
		return dist[N] <= K;
	}
}
