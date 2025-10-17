import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 20040. 사이클 게임

		// 번갈아서 하는 게임
		// 두점을 선택해서 선을 긋는다.
		// 처음 사이클이 완성되는 순간 게임은 종료

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 점의 수
		int m = Integer.parseInt(st.nextToken()); // 관계의 수

		parent = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (find(a) == find(b)) { // 사이클이 생기는지 확인
				System.out.println(i + 1);
				break;
			} else {
				union(a, b);

				if (i == m - 1) { // 종료시까지 매칭이 없다면 0출력
					System.out.println(0);
				}
			}
		}

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}

	}

	private static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

}
