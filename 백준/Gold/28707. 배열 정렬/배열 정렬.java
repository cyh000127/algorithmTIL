import java.util.*;
import java.io.*;

/**
 * 28707 배열 정렬
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 길이가 N인 양의 정수로 이루어진 배열
		// 비내림차순 (오름차순)이 되도록 정렬하기 위해 M가지 조작 가능

		// A의 li번째 수와 ri번째 수를 바꿈 비용은 ci가 듬 ( 1 <= i <= M )
		// A를 비 내림차순으로 바꾸기 위해 필요한 비용의 총합 (최소값)을 출력

		// 비 내림차순으로 만들 수 없다면 -1을 출력

		int n = Integer.parseInt(br.readLine());

		int[] init = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			init[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());

		// 방향 없음
		int[][] op = new int[m][3];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			op[i][0] = Integer.parseInt(st.nextToken()) - 1;
			op[i][1] = Integer.parseInt(st.nextToken()) - 1;
			op[i][2] = Integer.parseInt(st.nextToken());
		}

		int[] target = init.clone();
		Arrays.sort(target);

		// pq 초기화
		PriorityQueue<State> pq = new PriorityQueue<>();
		pq.add(new State(init, 0));

		// 특정 배열 상태를 얼마의 비용으로 방문했는지 저장할 hashmap
		// int[]는 참조타입이기 때문에 String으로 변환
		HashMap<String, Integer> visit = new HashMap<>();
		
		// 시작 배열 , cost = 0  초기화
		visit.put(Arrays.toString(init), 0);

		// 다익스트라 수행
		while (!pq.isEmpty()) {
			State now = pq.poll();

			
			// 탈출 조건 -> target과 지금 배열이 같다면 now.cost 출력
			if (Arrays.equals(target, now.a)) {
				System.out.println(now.cost);
				return;
			}

			for (int[] o : op) {
				int l = o[0];
				int r = o[1];
				int c = o[2];

				int[] clone = now.a.clone();

				// l번과 r번 swap
				int tmp = clone[l];
				clone[l] = clone[r];
				clone[r] = tmp;

				int newCost = now.cost + c;
				String newState = Arrays.toString(clone);

				// 방문한 적 없거나 기존 값보다 새 값이 저렴하면
				if (!visit.containsKey(newState) || visit.get(newState) > newCost) {
					pq.add(new State(clone, newCost));
					visit.put(newState, newCost);
				}
			}
		}
		System.out.println(-1);
	}

	static class State implements Comparable<State> {
		int cost;
		int[] a;// 배열 상태

		State(int[] a, int cost) {
			this.a = a;
			this.cost = cost;
		}

		@Override
		public int compareTo(State o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}