import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 백준
		// 1654. 랜선 자르기

		// K개의 랜선으로 N개의 랜선을 만들어야함(만들 수 없는 경우는 없음)
		// N개를 만들 수있는 최대 랜선 길이를 구해라

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		long min = 1; // 0 넣으면 오류 뜸 0을 분모로 쓸 수 없기 떄문
		long max = -1;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		
		while (min <= max) {
			long mid = (min + max) / 2;
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				cnt += arr[i] / mid;
			}

			if (cnt >= K) {
				min = mid + 1;
			} else if (cnt < K) {
				max = mid - 1;
			} 

		}
		System.out.println(max);
	}
}