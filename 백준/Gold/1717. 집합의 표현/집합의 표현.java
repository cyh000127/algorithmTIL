import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 1717. 집합의 표현

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 0 a b -> a번 ,b번 원소는 같은 집합이다.
		// 1 a b -> 두 원소가 같은 집합인지 확인하는 연산

		// 1이 입력될때 두 집합이 같은 집합이면 YES / 아니라면 NO 출력

		parent = new int[n + 1];

		// 각 원소가 자기 자신을 가리키게 먼저 설정
		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int q = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// q가 1일때
			if (q == 1) {
				// 둘의 부모가 같다면 YES
				// 아니라면 NO
				if (find(a)==find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			} else {
//				System.out.println("a = " +a+"b = "+b);
				union(a, b);
			}
//
//			for (int p : parent) {
//				System.out.print(p + " ");
//			}
//			System.out.println();
		}
	}

	// 유니온
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[a] = b;
		}

	}

	// 파인드
	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}
