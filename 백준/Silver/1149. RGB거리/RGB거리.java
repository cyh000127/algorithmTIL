import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] rgb;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 백준
		// 1149. RGB 거리

		// 1부터 N 까지의 집이 있음
		// 1. 1번 집은 2번 집과 색이 달라야 한다.
		// 2. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
		// 3. i번 집의 색은 i-1, i+1번 집의 색과 같지 않아야한다.

		// 입력
		// N
		// 각 집 별로 R, G, B 의 비용

		N = Integer.parseInt(br.readLine());
		rgb = new int[N][3];
		// 0 R / 1 G / 2 B
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new Integer[N][3]; // null 값을 찾아보기 위해 배열을 Integer로 선언

		
		//처음 집을 r,g,b로 색칠했을때 각각 계산해서 최소 계산
		int a = Math.min(find(0, 0), Math.min(find(0,1), find(0,2)));
		
		System.out.println(a);
	}

	// 최대 값을 찾아보자
	private static int find(int x, int color) {
		if (x == N - 1) { // x가 N-1번째 집까지 칠했다면 종료한다.
			return rgb[x][color];
		}

		if (dp[x][color] != null) { // 이미 칠해져 있는 집이라면 반환
			return dp[x][color];
		}

		// 칠해져 있지 않다면 x에서 칠한 색을 제외한 나머지 두 색중 최소가 되는 값을 찾아라
		dp[x][color] = Math.min(find(x + 1, (color + 1) % 3), find(x + 1, (color + 2) % 3)) + rgb[x][color];

		return dp[x][color];
	}
}