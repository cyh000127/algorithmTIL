import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 1 ~ N 까지의 문제집을 풀려고함
		// 난이도 순서로 되어있음
		// 1번문제가 가장쉬운 문제

		// 1. 문제는 모두 풀어야 함
		// 2. 먼저 푸는게 좋은 문제는 먼저 풀어야함
		// 3. 쉬운문제 부터 풀어야함
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점
		int M = Integer.parseInt(st.nextToken()); // 간선

		List<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		int[] inDegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			inDegree[end]++;
			list[start].add(end);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < N + 1; i++) {
			if (inDegree[i] == 0)
				pq.add(i);
		}

		while (!pq.isEmpty()) {
			int curr = pq.poll();

			sb.append(curr).append(" ");
			for (int x : list[curr]) {
				inDegree[x]--;
				if (inDegree[x] == 0) {
					pq.add(x);
				}

			}
		}
		System.out.println(sb.toString().trim());
	}
}
