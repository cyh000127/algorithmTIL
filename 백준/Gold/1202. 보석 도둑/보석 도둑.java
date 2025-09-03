import java.util.*;
import java.io.*;

class jewel {
	int m; // 무게
	int k; // 가격

	jewel(int a, int b) {
		m = a;
		k = b;
	}

}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 백준 1202. 보석 도둑
		// 세계적인 도둑 상덕이의 이야기

		// 보석 개수 N
		// 각 보석은 무게 M 과 가격 V 를 가짐

		// 상덕이는 가방을 K개 가짐
		// 각 가방의 최대 무게는 Ci
		// 가방에는 최대 한개의 보석만 넣을 수 있음

		// 훔칠 수 있는 보석의 최대 가격

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 보석 개수
		int K = Integer.parseInt(st.nextToken()); // 가방 개수
		// 0 = 무게 M
		// 1 = 가격 V
		jewel[] j = new jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 무게
			int b = Integer.parseInt(st.nextToken()); // 가격

			j[i] = new jewel(a, b);
		}

		Arrays.sort(j, new Comparator<jewel>() {
			@Override
			public int compare(jewel o1, jewel o2) {
				if (o1.m == o2.m) {
					return o2.k - o1.k; // 보석 무게가 같으면 가격으로 내림차순
				}
				return o1.m - o2.m; // 보석 무게로는 오름차순
			}
		});

		int[] bag = new int[K];

		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(bag); // 가방 무게로 오름차순

		// 우선순위 큐 선언
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본 오름차순 ->  ' - ' 를 달아줘야함 
		long ans = 0; // 정답이 int 범위 내에서 끝나지 않음

		for (int i = 0, s = 0; i < K; i++) { 
			while (s < N && j[s].m <= bag[i]) { // 현재 가방 무게보다 작거나 같은 보석을 모두 pq에 넣음
				pq.offer(-j[s++].k);
			}
			
			if(!pq.isEmpty()) {
				ans+=-pq.poll();
			}
		}
		System.out.println(ans);
	}
}
