import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int x = 0; 
        for(int i=num_list.length-1; i>=0; i--){
            answer[x] = num_list[i];
            x++;
            }
        return answer;
    }
}