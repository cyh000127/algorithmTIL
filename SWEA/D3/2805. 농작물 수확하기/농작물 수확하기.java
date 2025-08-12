import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		// 테스트케이스
		for (int test = 1; test <= T; test++) {
			// 농장의 크기 N
			int N = Integer.parseInt(br.readLine());

			// 농장은 항상 홀수이다.
			// 수확은 항상 농장의 크기에 딱 맞는 마름모 이다.

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';

				}
			}
			// 디버그용 코드
//			for(int i = 0 ; i<N; i++) {
//				
//				for(int j= 0; j<N;j++) {
//					System.out.print(arr[i][j]+ " ");
//				}
//				System.out.println();
//			}
//			

			// 5x5 라면 3 에서 시작하고
			// 절반으로 나누어서 중간 지점 r을 기준으로 시작
			// 위로 한 칸 움직이면 0+1 에서 출발하고 n-1까지 감
			// 위로 두 칸 움직이면 0+2 에서 출발하고 n-2까지 감
			// 기준점 r 은 모든 면을 다 더하는 중간 부분 idx
			int idx = N / 2;

			// 이득
			int ben = 0;
			// 위아래를 나눠서 반씩 계산할거에요
			// 위로 (가운데 부분 제외)
			for (int r = 1; r <= idx; r++) {
				// 한칸씩 올라갈수록 앞 idx와 뒤 idx가 1씩 줄어드는 문제
				for (int c = 0 + r; c < N - r; c++) {
					ben += arr[idx - r][c];
				}
			}
			// 아래로 (가운데 부분 제외)
			for (int r = 1; r <= idx; r++) {
				// 한칸씩 올라갈수록 앞idx와 뒤idx가 1씩 줄어드는 문제
				for (int c = 0 + r; c < N - r; c++) {
					ben += arr[idx + r][c];
				}
			}
			// 가운데 계산
			for (int i = 0; i < N; i++) {
				ben += arr[idx][i];
			}
			System.out.println("#" + test + " " + ben);
		}
	}
}
