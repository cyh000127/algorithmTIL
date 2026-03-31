import java.util.*;
import java.io.*;

/*
 * 루미와 블록 쌓기 게임
 */
public class Main {
	static class StackInfo implements Comparable<StackInfo> {
		int need; // 폭발하기 위해 필요한 추가 메모리
		int mem; // 폭발했을 때 다른 스택들에 더해지는 메모리

		StackInfo(int need, int mem) {
			this.need = need;
			this.mem = mem;
		}

		@Override
		public int compareTo(StackInfo o) {
			return Integer.compare(this.need, o.need);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 메모리가 용량 초과시 3초후 스택이 터짐
		// 폭발 나면 다른 모든 스택의 메모리에 /2만큼 더함

		// 9가 폭발 -> 다른 애들한테4만큼 추가

		// 연쇄적으로 가능

		// N개의 스택 밀반입
		// 몇개가 터질지 알아보자

		// 용량, 충전 메모리

		int n = Integer.parseInt(br.readLine());
		int[] c = new int[n];
		int[] m = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}

		StackInfo[] arr = new StackInfo[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new StackInfo(c[i] - m[i] + 1, m[i]);
		}

		// 오름차순 정렬
		Arrays.sort(arr);

		long nextAdd = 0;
		int ans = 0;
		int idx = 0;

		while (true) {
			int start = idx;

			// 현재 add만으로 이번 라운드에 폭발할 스택들
			while (idx < n && arr[idx].need <= nextAdd) {
				idx++;
			}

			if (start == idx) {
				break;
			}

			long roundGain = 0;

			for (int i = start; i < idx; i++) {
				roundGain += (arr[i].mem + nextAdd) / 2;
			}

			nextAdd += roundGain;
			ans += (idx - start);

			if (nextAdd >= 1_000_000) {
				System.out.println(n);
				return;
			}
		}

		System.out.println(ans);
	}
}