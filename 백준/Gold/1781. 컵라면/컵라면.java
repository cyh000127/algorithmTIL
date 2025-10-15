import java.io.*;
import java.util.*;

class Quest implements Comparable<Quest> {
	int timeline;
	int reward;

	public Quest(int t, int r) {
		this.timeline = t;
		this.reward = r;
	}

	// 1. reward(컵라면) 내림차순
	// 2. timeline 오름차순
	@Override
	public int compareTo(Quest o) {
		if (o.reward == this.reward) {
			return this.timeline - o.timeline;
		}
		return o.reward - this.reward;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 1781. 컵라면

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Quest> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Quest(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int sum = 0; // 받을 컵라면의 최대

		boolean[] rewardNoodle = new boolean[N + 1];

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		while (!pq.isEmpty()) {
			Quest currentQuest = pq.poll();
			int deadline = currentQuest.timeline;
			int reward = currentQuest.reward;

			// find를 통해 풀 수 있는 시간을 찾음
			int posTime = find(deadline);

			// 풀수 있는 날짜가 있다면
			if (posTime > 0) {
				sum += reward;
				// 그 날을 union
				union(posTime, posTime - 1);
			}
		}
		System.out.println(sum);
	}

	static int[] parent;

	// 가장빠른 부모를 찾는 find 연산
	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	// union을 통해 합침
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parent[rootA] = rootB;
		}
	}
}
