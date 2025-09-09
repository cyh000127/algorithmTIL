import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			Stack<Character> stack = new Stack<>();

			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {
				char now = str.charAt(i);
				if (now == '(')
					stack.push(now);
				else if (!stack.isEmpty() && now == ')')
					stack.pop();
				else {
					stack.push('3');
					break;
				}
			}
			if (stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}
}
