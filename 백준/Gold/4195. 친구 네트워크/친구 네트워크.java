import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int[] networkSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 4195. 친구 네트워크

		int T = Integer.parseInt(br.readLine()); // tc 수

		while (T-- > 0) {

			int F = Integer.parseInt(br.readLine()); // 친구 관계 수

			// 중복 방지를 위한 인원수 계산 map
			Map<String, Integer> Plist = new HashMap<>();
			int idx = 1;

			// 유니온,파인드를 위한 parent;
			parent = new int[2 * F + 1]; // 최대 생성 가능한 인원 수
			networkSize = new int[2 * F + 1];

			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());

				String a = st.nextToken();
				String b = st.nextToken();

				// a에 대해서 진행
				if (!Plist.containsKey(a)) {
					Plist.put(a, idx);
					parent[idx] = idx; // 자기자신을 부모로 가짐
					networkSize[idx] = 1; // 관계의 크기는 1
					idx++;
				}
				// b에 대해서도 진행
				if (!Plist.containsKey(b)) {
					Plist.put(b, idx);
					parent[idx] = idx; // 자기자신을 부모로 가짐
					networkSize[idx] = 1; // 관계의 크기는 1
					idx++;
				}

				int aIndex = Plist.get(a);
				int bIndex = Plist.get(b);

				union(aIndex, bIndex);
			}

		}

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		int aCnt = networkSize[a];
		int bCnt = networkSize[b];
		int apb = aCnt + bCnt;

		if (a != b) {
			parent[a] = b;
			// 다르면 합치고
			System.out.println(apb);

			// 관계의 크기 출력
			networkSize[a] = apb;
			networkSize[b] = apb;

		} else
			// 같으면 aCnt 출력
			System.out.println(aCnt);

	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}
