import java.io.*;
import java.util.*;

public class Solution {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N명
			int M = Integer.parseInt(st.nextToken()); // M관계

			arr = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				arr[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			}
			Set<Integer> set = new HashSet<>();
			for(int i =1  ; i<=N; i++) {
				set.add(findSet(i));
			}
			System.out.println("#"+tc+" "+set.size());
		}
	}

	private static void union(int a, int b) {
		int x = findSet(a);
		int y = findSet(b);

		if (x != y) {
			arr[x] = y;
		}
	}

	private static int findSet(int a) {
		if (arr[a] == a)
			return a;
		
		return arr[a] = findSet(arr[a]);

	}
}
