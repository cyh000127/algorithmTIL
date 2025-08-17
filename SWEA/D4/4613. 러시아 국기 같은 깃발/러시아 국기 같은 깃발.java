import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 지정
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 2차원 배열 선언
			int[][] arr = new int[r][3];
			// 배열에 W,R,B, 삽입 하는것 보다 W,B,R 개수만 세면 더 쉽지 않을까?
			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int j = 0; j < c; j++) {
					if (str.charAt(j) == 'W')
						arr[i][0]++;
					else if (str.charAt(j) == 'B')
						arr[i][1]++;
					else if (str.charAt(j) == 'R')
						arr[i][2]++;
				}
			}

			// 러시아 국기 처럼 W, B, R 순으로 만들어야 함
			// 최소 한줄씩만 껴 있으면 되니 w1b1r8 이런 기형적인 구조도 가능
			// 맨 위는 항상 W / 맨 아래는 항상 R 이여야 함
			// 일단 이전 줄이 W,B,R 중 어느것인지 확인하는 if문 사용
			// W -> W,B만 가능
			// B -> B,R만 가능
			// R -> R만 가능
			// 이런 식으로 바꾸면 다음 줄 상황도 확인해야 변환의 최소 횟수를 구할 수 있음
			// 차라리 줄당 계산이 아닌 모든 줄을 색칠한다고 가정한 후 계산해보자
			// 결론 ! 일단 풀어보자

			// 마지막 정답을 담을 ans
			int ans = Integer.MAX_VALUE;
			// i -> W는 0번째 줄 부터 최대 r-2줄까지 가능
			// j -> B는 i+1 번째 줄 부터 최대 r-1 줄 까지 가능
			// 나머지 남은 줄은 모두 W
			for (int i = 0; i < r - 2; i++) {
				for (int j = i + 1; j < r - 1; j++) {
					int cnt = 0;
					// W = 0
					// B = 1
					// R = 2
					for (int W = 0; W <= i; W++) {
						cnt += arr[W][1] + arr[W][2];
					}
					for (int B = i + 1; B <= j; B++) {
						cnt += arr[B][0] + arr[B][2];
					}
					for (int R = j + 1; R < r; R++) {
						cnt += arr[R][1] + arr[R][0];
					}
					ans = Math.min(ans, cnt);
				}

			}
			System.out.println("#"+test+ " "+ ans);
		}

	}
}
