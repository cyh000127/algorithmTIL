import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        // t초 붕대감으면서 초마다 x 만큼 회복
        // t초 붕대 감으면 y 만큼 추가 회복 
        // 당연히 최대체력 존재
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        // 공격시간 , 피해량 2차원 정수 배열
        // 공격시간 기준 오름 차순
        // 모든 공격이 끝난 후 남은 체력
        // 죽으면 -1 리턴
        
        // 감는 도중 공격 받으면 취소
        // 공격 순간에는 체력 회복 불가
        
        // 첫 공격 받기 전에는 아무 행동도 못하기 때문에 시작을 공격받은 후로 잡음
        int time = attacks[0][0];
        int hp = health-attacks[0][1];
        if(hp <=0) return -1;
        
        
        for(int i =1; i<attacks.length; i++){
            int next_attackTime = attacks[i][0];
            int d = attacks[i][1];
            
            hp += (next_attackTime - time-1)*x;
            hp += ((next_attackTime-time-1)/t) *y;
            if(hp >= health) hp =health;
            
            hp -= d;
            if(hp <=0) return -1;
            time = next_attackTime;
        }
      
        return hp;
    }
}