import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        
        long left = 1;
        long right = times[times.length-1] * (long)n;

        while(left <= right){
            long mid = left +(right-left)/2;
            long p = 0;

            for(int time : times){
                p += mid/time;

                if(p>=n){
                    break;
                }
            }
            
            if(p>=n){
                answer = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }

        return answer;
    }
}