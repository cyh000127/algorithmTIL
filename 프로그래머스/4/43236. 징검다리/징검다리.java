import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int answer = 0;
        int left = 1;
        int right = distance;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int prev = 0;
            int removed = 0;

            for (int rock : rocks) {
                int gap = rock - prev;

                if (gap < mid) {
                    removed++;
                } else {
                    // 현재 바위를 유지할 때만 기준점 갱신
                    prev = rock;
                }

                if (removed > n) {
                    break;
                }
            }

            // 마지막으로 남긴 바위와 도착점 사이 확인
            if (distance - prev < mid) {
                removed++;
            }

            if (removed <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}