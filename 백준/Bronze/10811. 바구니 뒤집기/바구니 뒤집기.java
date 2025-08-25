import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 범위를 정하고 그 안의 바구니를 역순으로 바꿀것임
		// 기본 상태는 순서대로 있음
		// 맨앞이 1임
		// 첫쨰 줄에 바구니 개수 N
		// 얼마나 바꿀건지 M이 주어짐

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1]; // 1번 바구니부터 시작하기 때문
		for (int i = 1; i < N + 1; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			if (right == left)
				continue;
			while (left < right) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left++;
				right--;
			}
		}

		for (int i = 1; i < N + 1; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}
