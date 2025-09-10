import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[] truth;
	static int count;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 사람의 수
		M = Integer.parseInt(st.nextToken()); // 파티의 수

		arr = new int[N + 1][2]; // 배열이 자기 자신을 가리키게 초기화
		st = new StringTokenizer(br.readLine());
		int people = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 :skull:

		truth = new boolean[N + 1]; // 사람 번호가 1 부터 시작
		for (int i = 0; i < people; i++) {
			int a = Integer.parseInt(st.nextToken());
			truth[a] = true;
		}

		LinkedList<int[]> list = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 파티에 오는 멤버 수
			int[] s = new int[a];
			int p = 0;
			while (a-- > 0) {
				s[p++] = Integer.parseInt(st.nextToken());
			}
			list.add(s); // 리스트에 담기
		}

		// 유니온 파인드를 위해 arr[i][0]이 자기 자신의 idx 값을 가리키게 정리
		for (int i = 1; i < N + 1; i++) {
			arr[i][0] = i;
			arr[i][1] = 0; // 진실을 모른다고 가정 초기화
		}

		// union을 통해 만약 list의 요소중 하나라도 진실을 안다면 모든 arr[i][1]을 1(진실)로 만듬
		// + arr[i][0]이 해당 idx를 가리키게 만듬
		for (int[] party : list) {
			if (party.length > 1) {
				int firstPerson = party[0];
				for (int i = 1; i < party.length; i++) {
					union(firstPerson, party[i]);
				}
			}
		}

//		// 디버그용 코드
//		for (int i = 0; i < M; i++) {
//			int[] k = list.get(i);
//			for (int j = 0; j < k.length; j++) {
//				System.out.println(arr[k[j]][0] + " " + arr[k[j]][1]);
//			}
//			System.out.println("----------");
//		}

		int ans = 0;

		// 진실을 알고있는 집단 만들기
		for (int i = 1; i <= N; i++) {
			if (truth[i]) {
				int root = findSet(i);
				arr[root][1] = 1; // 그 집합의 대표(root)가 진실을 안다고 표시
			}
		}

		// 순회하면서 arr[k][1]이 0을 가지는지 확인 -> 0이면 구라쳐도 됨!!
		for (int[] party : list) {
			if (party.length > 0) {
				int root = findSet(party[0]);
				if (arr[root][1] == 0)
					ans++;
			}

		}
		System.out.println(ans);
	}

	private static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rootA != rootB) {
			// 일반적으로 한쪽을 다른 쪽에 붙임 (번호가 작은 쪽으로 합치기 등)
			if (rootA < rootB) {
				arr[rootB][0] = rootA;
			} else {
				arr[rootA][0] = rootB;
			}
		}
	}

	private static int findSet(int x) {
		if (arr[x][0] == x) {
			return x;
		}
		return arr[x][0] = findSet(arr[x][0]);
	}

}