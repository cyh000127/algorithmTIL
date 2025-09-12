import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 두 학생의 키를 비교하는 ( 간선 )
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수 
		int M = Integer.parseInt(st.nextToken()); // 키 잰 수

		List<Integer>[] arr = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		int[] inDegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			inDegree[to]++;
			arr[from].add(to);

		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < N+1; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int curr = q.poll();

			sb.append(curr).append(" ");

			for (int x : arr[curr]) {
				inDegree[x]--;
				if (inDegree[x] == 0)
					q.add(x);
			}
		}
		System.out.println(sb.toString().trim());
	}
}