import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	static int[][] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 백준
		// 1932. 정수 삼각형

		// 크기가 N인 삼각형이 있다.
		// 맨 위에서 출발해서 왼쪽, 오른쪽으로만 이동이 가능함
		// 최대가 되는걸 선택하게 하셈

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
			}
		}
		System.out.println(arr[0][0]);
	}
}