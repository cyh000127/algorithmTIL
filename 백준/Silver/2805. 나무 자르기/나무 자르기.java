import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 백준
		// 2805. 나무 자르기
		// 파라매트릭 서치

		// 나무의 특정 높이를 설정
		// 모두 그 길이를 기준으로 잘림
		// 적어도 M미터의 나무를 집에 가져가려면 어느 높이로 설정해야하나

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int left = 0;
		int right = -1;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			long tree = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] > mid)
					tree += arr[i] - mid;
			}
			if (tree >= m) {
				left = mid + 1;
			} else if (tree < m) {
				right = mid - 1;
			}
		}

		System.out.println(right);
	}
}