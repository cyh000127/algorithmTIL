import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        // 아직 가격이 떨어지지 않은 시점의 인덱스
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 현재 가격이 이전 가격보다 낮다면 가격이 떨어진 것
            while (!stack.isEmpty()
                    && prices[stack.peek()] > prices[i]) {

                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        // 끝까지 가격이 떨어지지 않은 시점들
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = n - 1 - index;
        }

        return answer;
    }
}