import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1번 부터 N번 까지 번호가 매겨진 바구니가 있음
		// 공이 한개씩 들어있는데 그 공에도 바구니 번호가 잇음
		// M번 공을 바꿀건데 바구니 2개를 고른 후 두 바구니의 공을 서로 교환함
		// M번 공을 바꾼 후 바구니에 어떤공이 들어있는지 구하시오

		// 바구니 N
		// 바꾸는 횟수 M
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1]; // 1번바구니부터 시작하니 +1해줌

		for (int i = 1; i < N + 1; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(arr[i]);
			if (i < N)
				sb.append(" ");
		}
		System.out.println(sb);
	}

}
