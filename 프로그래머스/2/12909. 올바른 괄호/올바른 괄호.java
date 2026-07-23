import java.util.*;

class Solution{
   boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
       
        if (s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') return false;
       
       
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        answer = stack.isEmpty();
        return answer;
    }
}