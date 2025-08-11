import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			char[] strArr = st.nextToken().toCharArray();

			ArrayDeque<Character> stack = new ArrayDeque<Character>();

			for (int i = 0; i < len; i++) {
				if (!stack.isEmpty() && stack.peek() == strArr[i]) {
					stack.pop();
					continue;
				} else
					stack.push(strArr[i]);
			}
			StringBuilder sb = new StringBuilder();
			
			while (!stack.isEmpty())
				sb.append(stack.pop());
			System.out.println("#"+tc+" " + sb.reverse());

		}
	}
}