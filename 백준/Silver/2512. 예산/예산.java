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
		// 2512. 예산

		// 가능한 최대의 예산을 책정해야함
		// 1. 모든 요청이 배정될 수 있는 금액 그대로 배정
		// 2. 모든 요청을 들어줄 수 없다면 정수 상한액을 계산
		// 2-1. 그 이상인 요청에는 모두 상한액 배정
		// 2-2. 상한액 이하는 요청 금액 대로 배정

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N]; // 지역별로 원하는 예산

		long min = 1;
		long max = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		int M = Integer.parseInt(br.readLine());

		while (min <= max) {
			long mid = (min + max) / 2;
			long cnt = 0;
			
			for (int i = 0; i < N; i++) {
				if (arr[i] < mid) {
					cnt += arr[i];
				} else {
					cnt += mid;
				}

			}
			if (cnt > M) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(max);
	}
}