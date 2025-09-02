import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] arr; // cols[i] = i행의 퀸의 열 위치 arr[2] =3 이라면 2,3에 있는 것
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			// N * N 보드에서 N 개의 퀸을 서로다른 두 퀸이 공격하지 못하게 놓는 경우의 수는 ?
			// N이 1 이면 1*1보드의 1개의 퀸
			// N이 2이면 2*2 보드의 2개의 퀸 . .. .

			N = Integer.parseInt(br.readLine());
			arr = new int[N];// N*N의 arr 지도
			cnt = 0;
			findNqueen(0);
			System.out.println("#" + test + " " + cnt);
		}
	}

	private static void findNqueen(int a) {
		if (a == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[a] = i; // (a,i) 위치에 퀸을 놓는다.
			
			// 다음 위치 고려
			if (check(a)) { // check를 통해 이동이 가능한지 확인 
				findNqueen(a + 1); // 놓을 수 있는 위치라면 다음 행으로 이동
			}
		}
	}

	private static boolean check(int a) {
		for (int i = 0; i < a; i++) { // 첫 queen보다 낮은 idx에 놓을 것이기 때문에 수평 검사완
			// 수직 검사
			if (arr[i] == arr[a]) {
				return false;
			}
      
			// 대각선 검사
			if (Math.abs(a - i) == Math.abs(arr[i] - arr[a])) {
				return false;
			}
		}
		return true;
	}
}
