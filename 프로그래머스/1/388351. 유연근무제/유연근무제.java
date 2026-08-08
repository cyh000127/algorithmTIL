import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // 출근지정시간 +10분 까지 출근해야함
        // 토, 일 출근은 예외
        // n명의 출근희망시간 schedules
        // 출근한 시간 timelogs 
        // 시작 요일 startday [1,2,3,4,5,6,7]
        
        // 상품 받는 직원 수 return
        
        int n = schedules.length;
        int day = startday;
        for(int i =0 ; i<n;i++){
            day = startday;
            int target = calc(schedules[i]);
            int days = 0 ;
            for(int j=0;j<timelogs[0].length; j++){
                if(day==6 || day ==7){
                    day =(day%7)+1;
                    continue;
                }
                if(target + 10 >= calc(timelogs[i][j])){
                    days++;
                }
                day =(day%7)+1;
            }
            if (days==5){
                answer++;
            }
        }
        
        return answer;
    }
    
    public int calc(int s){
           return (s/100)*60 + s%100;

    }
}