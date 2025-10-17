import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 1976. 여행 가자

		int N = Integer.parseInt(br.readLine()); // 도시 수
		int M = Integer.parseInt(br.readLine()); // 여행 계획

		parent = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}

		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		boolean isPos = true;
		int start = Integer.parseInt(st.nextToken());
		
		// 여행 갈 수 있는지 확인하기
		while (st.hasMoreTokens()) {
			int next =Integer.parseInt(st.nextToken());
			if(find(start)==find(next)) {
				start = next;
			} else {
				System.out.println("NO");
				isPos =false;
				break;
			}
		}
		if(isPos) {
			System.out.println("YES");
		}

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}

	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}
