import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // N 은 문자열 길이
            int M = Integer.parseInt(st.nextToken()); // M 은 찾을 회문의 길이

            String str = br.readLine();
            char[] ch = str.toCharArray();

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test).append(" ");
            
            // 회문의 시작점 i를 0부터 N-M까지 순회
            boolean isPalindrome = false;
            for (int i = 0; i <= N - M; i++) {
            	  isPalindrome = true;  
                // M/2 만큼만 검사하면 됨
                for (int j = 0; j < M / 2; j++) {
                    // 회문의 앞 부분 (i + j) 와 뒷 부분 (i + M - 1 - j) 비교
                    if (ch[i + j] != ch[i + M - 1 - j]) {
                        isPalindrome = false;
                        break;
                    }
                }
                
                if (isPalindrome) {
                    // 회문이 맞으면 M 길이만큼 출력
                    for (int k = 0; k < M; k++) {
                        sb.append(ch[i + k]);
                    } 
                    // 회문을 찾았으면 더 이상 찾을 필요가 없으므로 루프 종료
                    break;
                } 
            }
            
            if(!isPalindrome) sb.append("NONE");
            System.out.println(sb);
        }
    }
}