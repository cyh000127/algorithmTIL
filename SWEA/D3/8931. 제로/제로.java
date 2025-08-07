import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 T 선언
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			// 테스트케이스 별 실행 횟수 n
			int n = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> stack = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {
				// 0이면 pop / 0이 아니면 push
				int A = Integer.parseInt(br.readLine());
				if (A == 0 && !stack.isEmpty()) {
					stack.pop();
				} else
					stack.push(A);
			}
			int ans = 0;
			while (!stack.isEmpty()) {
				ans += stack.pop();
			}
			
			System.out.println("#"+ test+" "+ ans);
		}
	}
}
