import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            // 테스트케이스의 길이는 사용하지 않으므로 읽기만 함
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();

            ArrayDeque<Character> stack = new ArrayDeque<>();
            int isValid = 1;

            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);

                if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                    // 여는 괄호일 경우 스택에 추가
                    stack.push(ch);
                } else { // 닫는 괄호일 경우
                    // stack이 비었다면 닫는 괄호 시작 ==> break;
                    if (stack.isEmpty()) {
                        isValid = 0;
                        break;
                    }

                    char top = stack.peek(); // 스택의 최상단 괄호 확인

                    // 짝이 맞으면 pop
                    if ((ch == ')' && top == '(') ||
                        (ch == ']' && top == '[') ||
                        (ch == '}' && top == '{') ||
                        (ch == '>' && top == '<')) {
                        stack.pop();
                    } else { // 짝이 맞지 않으면 유효하지 않음
                        isValid = 0;
                        break;
                    }
                }
            }

            // 모든 문자열을 처리한 후 스택에 괄호가 남아있다면 유효하지 않음
            if (!stack.isEmpty()) {
                isValid = 0;
            }

            System.out.println("#" + testCase + " " + isValid);
        }
    }
}