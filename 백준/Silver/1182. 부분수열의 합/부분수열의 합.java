import java.io.*;
import java.util.*;

public class Main {
	static boolean[] check;
	static int S, N;
	static int cnt = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		// N개의 정수로 이루어진 수열에서
		// 그 원소의 합을 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		// 배열 선언 및 배열에 숫자 대입
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		find(0, 0);

		if (S == 0) {
			// S가 0일때를 구하는 로직일때는
			// 아무것도 안고르는것도 0이 되기 떄문에 그 case를 뺴줘야함
			cnt--;
		}
		System.out.println(cnt);
	}

	private static void find(int dp, int sum) {
		// if () 반환 조건 쓸 것
		// dp가 끝까지 갔을때 +
		// 합과 S가 같다면 cnt++;
		if (dp == N) {
			if (sum == S) {
				cnt++;
			}
			return;
		}
		find(dp + 1, sum + arr[dp]); // 해당 배열에서 하나 골라서 더했을때
		find(dp + 1, sum);// 해당하는 깊이의 문자를 계산하지 않을때 

	}
}
