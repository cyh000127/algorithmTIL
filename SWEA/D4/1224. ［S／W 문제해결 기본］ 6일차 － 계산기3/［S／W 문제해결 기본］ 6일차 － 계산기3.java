import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
 
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1;  tc <= 10 ; tc++) {
            int length = Integer.parseInt(br.readLine());
            String infix = br.readLine();
             
            // 스택에 있는 연산자의 우선순위
            Map<Character, Integer> inStackPriority = new HashMap<Character, Integer>();
            inStackPriority.put('(', 0);
            inStackPriority.put('*', 2);
            inStackPriority.put('/', 2);
            inStackPriority.put('+', 1);
            inStackPriority.put('-', 1);
             
            // 새로 들어오는 연산자의 우선순위
            Map<Character, Integer> incomingPriority = new HashMap<Character, Integer>();
            incomingPriority.put('(', 3);
            incomingPriority.put('*', 2);
            incomingPriority.put('/', 2);
            incomingPriority.put('+', 1);
            incomingPriority.put('-', 1);
             
            // 1) 중위표기 -> 후위표기 변환
            Deque<Character> operators = new ArrayDeque<Character>();
            StringBuilder postfix = new StringBuilder();
             
            for (char c : infix.toCharArray()) {
                if (Character.isDigit(c)) {
                    postfix.append(c);
                } else if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        postfix.append(operators.pop());
                    }
                    if (!operators.isEmpty()) { // '('를 스택에서 제거
                        operators.pop(); 
                    }
                } else { // 연산자
                    while (!operators.isEmpty() && inStackPriority.get(operators.peek()) >= incomingPriority.get(c)) {
                        postfix.append(operators.pop());
                    }
                    operators.push(c);
                }
            }
            while (!operators.isEmpty()) {
                postfix.append(operators.pop());
            }
             
            // 2) 후위표기 계산
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (char c : postfix.toString().toCharArray()) {
                if (Character.isDigit(c)) {
                    stack.push(c - '0');
                } else {
                    int rightOperand = stack.pop();
                    int leftOperand = stack.pop();
                    stack.push(calculate(c, leftOperand, rightOperand));
                }
            }
            System.out.println("#" + tc + " " + stack.pop());
        }
    }
    
    private static int calculate(char op, int left, int right) {
        switch (op) {
        case '+': return left + right;
        case '-': return left - right;
        case '*': return left * right;
        case '/': return left / right;
        }
        return 0;
    }   
}