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

			// () 온전한 공이라면 +1
			// (| 같은 것도 +1
			// |) 도 + 1
			// 위 세가지 케이스를 전부 더한 값을 출력
			
			int cnt = 0 ;
			for(int i = 0 ; i<ch.length-1; i++) {
				if(ch[i]=='(' && ch[i+1] ==')') cnt ++ ;
				if(ch[i]=='(' && ch[i+1] =='|') cnt ++;
				if(ch[i+1]==')' && ch[i] =='|') cnt ++;
			}
			System.out.println("#"+test+" "+cnt);
		}
	}
}