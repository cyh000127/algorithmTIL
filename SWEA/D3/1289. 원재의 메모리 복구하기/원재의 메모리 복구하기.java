import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {

			// 문장을 받아서 ch 에 저장
			char[] ch = br.readLine().toCharArray();

			//초기 값이 0 이기 때문에 ch[0]이 1로 시작한다면 +1
			int cnt = ch[0]-'0';
			// 연속되는 문자가 아닌 문자가 바뀔때마다 cnt 가 1씩 증가
			for (int i = 0; i < ch.length - 1; i++) {
				if (ch[i] != ch[i + 1])
					cnt++;
			}
			System.out.println("#"+test+" "+cnt);
		}
	}
}