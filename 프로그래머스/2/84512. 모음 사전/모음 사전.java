class Solution {
    public int solution(String word) {
      
        int len = word.length();
        
        // 5 * 5 * 5 * 5 + 5 * 5 * 5 + 5 * 5 + 5 + 1
        // = 781 (맨 앞자리 한 알파벳당 781)
        
        // 두번째 자리
        // 781(f-1) + 5*5*5 + 5*5 + 5 + 1  = 156
        // 156 + 781(f-1)
        
        // 세번째 자리 
        // 156(s-1) + 781(f-1) + 31
        
        // 네번 쨰 자리
        // 781 156 31 6
        // 781 156 31 6 1
        
        
        int ans = 0;
        for(int i =0 ; i<len ; i++){
            char c = word.charAt(i);
            int tmp = 0;
            if(c=='A'){
                tmp =0;
            } else if(c=='E'){
                tmp=1;
            } else if(c=='I'){
                tmp=2;
            }else if(c=='O'){
                tmp =3;
            }else tmp =4;
            // 781 156 31 6 1
           switch(i){
               case 0:
            ans+= tmp*781;
            break;
            case 1:
            ans+= tmp*156;
            break;
            case 2:
            ans+= tmp*31;
                  break;
            case 3:
            ans+= tmp*6;
            break;
               default: ans += tmp;
           }
                       ans+=1;
        }

        
        return ans;
    }
}