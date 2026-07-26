import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
 
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(String s : completion){
            if(hash.containsKey(s)){
                int x = hash.get(s);
                hash.put(s,x+1);
            }else{
               hash.put(s,1);                
            }
        }

        for(int i =0 ; i<participant.length; i++){
            String tmp = participant[i];
            
            if(!hash.containsKey(tmp)){
                answer= answer+tmp;
            } else if(hash.get(tmp) == 0){
                answer = answer+tmp;
            } else{
                hash.put(tmp, hash.get(tmp)-1);
            }
            
            
            
        }
        
        return answer;
    
        
        }
}