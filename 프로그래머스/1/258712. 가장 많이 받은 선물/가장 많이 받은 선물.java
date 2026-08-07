import java.util.*;

class Solution {
    
    static class board {
        String name;
        int give;
        int receive;
        
        board(String name, int give, int receive) {
            this.name = name;
            this.give = give;
            this.receive = receive;
        }
        
        public void given() {
            give++;
        }
        
        public void received() {
            receive++;
        }
    }
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 선물을 주고 받은 기록이 있다면 다음 달에는 더 많이 받은애가 선물해줌
        // 기록이 없거나 수가 같다면 선물 지수가 더 작은 사람이 선물해줌
        // 선물지수 : 준 선물 - 받은 선물
        
        // 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return
        
        HashMap<String, Integer> map = new HashMap<>();
        board[] b = new board[friends.length];
        int[][] gift = new int[friends.length][friends.length];
        
        for(int i = 0; i < friends.length; i++){
            b[i] = new board(friends[i], 0, 0);
            map.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++){
            String[] a = gifts[i].split(" ");
            int from = map.get(a[0]);
            int to = map.get(a[1]);
            
            fromto(b[from], b[to]);
            gift[from][to]++;
        }
        
        int[] next = new int[friends.length];
        
        for(int i = 0; i < friends.length; i++){
            for(int j = i + 1; j < friends.length; j++){
                
                if(gift[i][j] > gift[j][i]){
                    next[i]++;
                }
                else if(gift[i][j] < gift[j][i]){
                    next[j]++;
                }
                else{
                    int scoreI = b[i].give - b[i].receive;
                    int scoreJ = b[j].give - b[j].receive;
                    
                    if(scoreI > scoreJ){
                        next[i]++;
                    }
                    else if(scoreI < scoreJ){
                        next[j]++;
                    }
                }
            }
        }
        
        for(int i = 0; i < friends.length; i++){
            answer = Math.max(answer, next[i]);
        }
        
        return answer;
    }
    
    
    public void fromto(board from, board to){
        from.given();
        to.received();
    }
}