import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		// 선행 관계가 있다 -> 위상 정렬을 사용하자
		// 문제에서 테케가 10개라고 알려줌
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken()); // 정점
			int E = Integer.parseInt(st.nextToken()); // 간선

			List<Integer>[] arr = new ArrayList[V + 1];
			for (int i = 0; i < V+1; i++) {
				arr[i] = new ArrayList<>();
			}
			int[] inDegree = new int[V + 1];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				arr[to].add(from);
				inDegree[from]++;
			}

			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i < V + 1; i++) {
				if (inDegree[i] == 0)
					q.add(i);
			}

			sb.append("#").append(test);
			while (!q.isEmpty()) {
				int curr = q.poll();

				sb.append(" ").append(curr);
				for (int x : arr[curr]) {
					inDegree[x]--;

					if (inDegree[x] == 0) {
						q.add(x);
					}
				}
			}

			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}
