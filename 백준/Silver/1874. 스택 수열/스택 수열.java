import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		// 1부터 n까지의 수를 스택에 넣음

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		for (int i = 0; i < n; i++) {
			int curr = Integer.parseInt(br.readLine());

			while (idx <= curr) {
				stack.push(idx);
				idx++;
				sb.append('+').append('\n');
			}

			if (!stack.isEmpty() && stack.peek() == curr) {
				stack.pop();
				sb.append('-').append('\n');
			}

		}
		if(stack.isEmpty()) {
			System.out.println(sb.toString().trim());
		} else {
			System.out.println("NO");
		}
	}
}
