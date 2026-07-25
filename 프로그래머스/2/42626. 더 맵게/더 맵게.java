import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 스코빌 지수를 K 이상으로 만들고 싶다.
        // 가장 안매운애 + 덜 안매운애 (*2)
        // 최소 횟수를 return;
        
        // 가장
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int sco : scoville){
            pq.add(sco);
        }
        
        int cnt = 0 ;
        
        while(!pq.isEmpty()){
            int x = pq.poll();
            if(x>=K){
                break;
            }

            if(pq.isEmpty()){
                return -1;
            }
            int y = pq.poll();
        
            
            cnt++;
            pq.add(x+(y*2));
        }
        
        
        return cnt;

        }
    }
