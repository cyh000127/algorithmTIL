import java.util.*;
import java.io.*;

class Solution {

    static int[] pos1, op_start1, op_end1, video_len1;
    static int start , end; 
    // 0 prev | 1 next
    public void calc(int order){
    int current = pos1[0] * 60 + pos1[1];
    int video = video_len1[0] * 60 + video_len1[1];

    if (order == 0) {
        current = Math.max(0, current - 10);
    } else {
        current = Math.min(video, current + 10);
    }

    pos1[0] = current / 60;
    pos1[1] = current % 60;
}
    

    // 오프닝 계산
    public void op(){
         int nowPos = 100*pos1[0] + pos1[1];
         if(nowPos>=start && nowPos<= end){
                pos1[0] = op_end1[0];
                pos1[1] = op_end1[1];
            }
        }
    

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 10초전 , 10초후, 오프닝 건너뛰기
        // prev 10초 전 => 10초미만 = 처음 (0분 0초)
        // next 10초 후 => 남은시간 10초 미만 => 마지막 (동영상 길이)
        // 건너 뛰기 op_start ~ op_end 사이라면 op_end로 이동

        // video_len 동영상 길이 (끝 부분)
        // 재생 위치 (pos)
        // 오프닝 시작 op_start / 끝 op_end
        // 사용자의 입력 commands가 주어질때 마지막 동영상 위치를 "mm:ss"로 표현 

        int min = Integer.parseInt(video_len.substring(0,2));
        int sec = Integer.parseInt(video_len.substring(3,5));

        video_len1 = new int[]{min, sec};

        min = Integer.parseInt(pos.substring(0,2));
        sec = Integer.parseInt(pos.substring(3,5));

        pos1 = new int[]{min,sec};


        min = Integer.parseInt(op_start.substring(0,2));
        sec = Integer.parseInt(op_start.substring(3,5));

        op_start1 = new int[]{min,sec};

        min = Integer.parseInt(op_end.substring(0,2));
        sec = Integer.parseInt(op_end.substring(3,5));

        op_end1 = new int[]{min,sec};

        start = op_start1[0]*100+op_start1[1] ;
        end = op_end1[0]*100 + op_end1[1];
        
        op();

        for(int i = 0 ; i < commands.length; i++ ){
            if(commands[i].equals("prev")){
            calc(0);
            } else {
                calc(1);
            }

          op();
        }


        String mm= Integer.toString(pos1[0]);
        String ss = Integer.toString(pos1[1]);
        if(pos1[0]<10){
            mm = "0" +pos1[0];
        }
        if(pos1[1]<10){
            ss="0"+pos1[1];
        }

        return mm +":" + ss;

    }
}