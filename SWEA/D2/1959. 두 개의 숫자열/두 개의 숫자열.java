import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			// 배열 A는 N 개 / 배열 B는 M개의 숫자로 구성됨
			// 더 짧은 쪽이 큰쪽의 idx 위치만큼 이동 가능
			// 같은 idx를 가지는 애들끼리 곱한 후 짧은 쪽의 개수만큼 더함
			// 긴쪽의 끝 idx를 벗어나면 안됨

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			//A,B 배열 선언
			int[] arrA = new int[N];
			int[] arrB = new int[M];

			// A 배열에 수를 넣음
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}

			// B 배열에 수를 넣음
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			// 최댓값
			// N이 M 보다 크다면 N을 기준으로 M이 움직여야 함
			int ans = Integer.MIN_VALUE;
			int arrSum;
			if (N > M) {
				for (int n = 0; n < N - M+1; n++) {
					arrSum = 0;
					for (int m = 0; m < M; m++) {
						arrSum += arrA[m + n] * arrB[m];
					}
					ans = Math.max(arrSum, ans);
				}
			} else if (M > N) {
				// M이 N 보다 크다면 M을 기준으로 N이 움직여야 함
				for (int m = 0; m < M - N+1; m++) {
					arrSum = 0;
					for (int n = 0; n < N; n++) {
						arrSum += arrA[n] * arrB[m + n];
					}
					ans = Math.max(arrSum, ans);
				}
			} else {
				// N과 M의 길이가 동일하다면 그냥 출력
				arrSum = 0;
				for (int i = 0; i < M; i++) {
					arrSum += arrA[i] * arrB[i];
				}
				ans = arrSum;
			}
			System.out.println("#" + test + " " + ans);
		}
	}
}
