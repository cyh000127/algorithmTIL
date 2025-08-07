import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T ; test ++) {
		// 문자열을 담을 스택 선언
		ArrayDeque<Character> stack = new ArrayDeque<>();
		// str에 괄호 담기;
		String str = br.readLine();
		
		int N = str.length();
		//자른 개수
		int cutPipe = 0;
		for(int i = 0;  i<N; i++) {
			if(str.charAt(i)=='(') {
				if(i+1 <N &&str.charAt(i+1) ==')') {
					// 파이프가 아닌 레이저라면 파이프를 자르고 cutPipe에 더하기 
					cutPipe += stack.size();
						i++;//'()'을 처리하기 위해 i에 1 추가
				} else {
					// 스택에 추가
					stack.push(str.charAt(i));
				}
			}
			else if(str.charAt(i)==')') {
				if(stack.peek()== '(' && !stack.isEmpty()) {
					stack.pop();
					cutPipe++;
				}
			}
		}
		
		System.out.println("#"+test+" "+ cutPipe);
		}
	}
}
