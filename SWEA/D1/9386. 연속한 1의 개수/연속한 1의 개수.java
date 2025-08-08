import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 지정
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {

			//N개의 수열
			int N = Integer.parseInt(br.readLine());
			String nums = br.readLine();
			char[] arr = nums.toCharArray();
			
			// 1이 연속되는 횟수 cnt 세기
			// 가장 높은 cnt 출력 => maxCnt
			int cnt = 0;
			int maxCnt=0;
			for(int i = 0 ; i<N ; i++) {
				if(arr[i]== '1') {
					cnt ++;
				}else if(arr[i]=='0') {
					cnt = 0;
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			System.out.println("#"+test+" "+maxCnt);
		}
	}
}
