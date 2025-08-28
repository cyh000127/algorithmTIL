import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
			Stack<Character> stack = new Stack<>();
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			// 1 유효함
			// 0 유효하지 않음
			boolean is = true;
			for (int i = 0; i < len; i++) {
				if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '['|| str.charAt(i) == '<') {
					stack.add(str.charAt(i));
				} else {
					if (str.charAt(i) == '}' && stack.peek() == '{') {
						stack.pop();
					} else if (str.charAt(i) == ')' && stack.peek() == '(') {
						stack.pop();
					} else if (str.charAt(i) == ']' && stack.peek() == '[') {
						stack.pop();
					} else if (str.charAt(i) == '>' && stack.peek() == '<') {
						stack.pop();
					} else {
						is = false;
						break;
					}
				}
			}
			if (is) {
				System.out.println("#" + test + " " + 1);
			} else {
				System.out.println("#" + test + " " + 0);
			}
		}
	}
}