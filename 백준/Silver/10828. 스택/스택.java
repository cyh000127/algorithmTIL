import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int order = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int a = 0;
		for (int i = 0; i < order; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			// push
			if (str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			if (str.equals("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
			}
			if (str.equals("size")) {
				System.out.println(stack.size());
			}
			if (str.equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
			if (str.equals("top")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
			}

		}

	}
}
