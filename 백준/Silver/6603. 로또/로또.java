import java.io.*;
import java.util.*;

public class Main {
	static int N, S;
	static int[] arr;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		// 주어진 N개의 수에서
		// 6개의 수를 고르는 모든 방법을 서술하는 코드

		while (true) {
			String str = br.readLine();
			// str이 0이라면 종료
			if (str.equals("0")) {
				break;
			}

			StringTokenizer st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());

			arr = new int[N];
			check = new boolean[N];

			// 배열 선언 및 배열에 숫자 대입
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			find(0, 0);
			System.out.println(sb);
			sb.setLength(0); //StringBuilder 초기화
		}
	}

	private static void find(int dp, int start) {
		// 앞에서부터 수 하나씩 찾기
		// 6개를 다 찾은 상태라면 출력한 후 -> 하나 앞으로 돌아가기
		// 이미 찾아본곳인지 확인한 후 건너뛰고 다음거 찾기
		if (dp == 6) { // dp가 6이라면 6개의 수를 모두 찾은 것
			for (int i = 0; i < N; i++) {
				// check[i]가 true 라면 출력
				if (check[i]) {
					sb.append(arr[i]).append(" ");
				}
			}
			sb.append("\n");
		}
		for (int i = start; i < N; i++) {
			check[i] = true;
			find(dp + 1, i + 1);
			check[i] = false;
		}
	}
}