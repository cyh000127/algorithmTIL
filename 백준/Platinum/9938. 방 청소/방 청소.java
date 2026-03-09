import java.util.*;
import java.io.*;

/**
 * 9938 방 청소
 */
public class Main {
	static int n, l;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N개의 술병 300_000
		// L개의 서랍 300_000

		// 1. Ai가 비었다면 i번 술을 그 서랍에 보관
		// 2. Bi가 비었다면 i번 술을 그 서랍에 보관
		// 3. Ai에 들어있는 술을 Ai번째 위치에 들어갈 수 있는 서랍중 하나로 옮김
		// 그 서랍에도 이미 술이 있다면 -> 다른 서랍으로 이동시킴
		// i번 술을 Ai에 보관 함
		// 4. Bi에 들어있는 술을 다른 서랍으로 이동시킨다. ( 3번과 동일 )
		// 5. 1~4가 모두 불가능할 경우 술을 마셔버린다? 어린이날인데?
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		// 보관 가능 -> LADICA
		// 불가능 -> SMECE

		// 서랍
		int[] capacity = new int[l + 1];

		parent = new int[l + 1];

		for (int i = 0; i <= l; i++) {
			// 1로 초기화
			capacity[i] = 1;
			// 자기 자신을 가리키는 parent 배열
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int roota = find(a);
			int rootb = find(b);

			// roota를 rootb의 자식으로 보냄
			if (roota != rootb) {
				parent[roota] = rootb;
				// 빈 서랍 정보를 rootb에 몰빵
				capacity[rootb] += capacity[roota];
				// roota 초기화
				capacity[roota] = 0;
			}

			// 합쳐진 집합에 빈 서랍 공간이 남아있는지 확인
			if (capacity[rootb] > 0) {
				capacity[rootb]--;

				sb.append("LADICA").append("\n");
			} else {
				sb.append("SMECE").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		// 경로를 압축해서 시간을 조금 더 빠르게 가져감
		return parent[a] = find(parent[a]);
	}
}
