class Solution {
    
    
    
    public int[] solution(String[] park, String[] routes) {
      
        // park 갈거야
        // 명령 배열이 있음
        // 모든 명령 후 위치 세로, 가로 배열로 출력
        
        //길 O 장애물 X
        // 맵 밖으로 안나가는지
        // 장애물 없는지 검사
        // 하나라도 걸리면 명령 무시
        
        int r = park.length;
        int c = park[0].length();
        
        int[][] map = new int[r][c];
        
        int nr =0 ,nc =0  ;
        for(int i =0 ; i<r; i++){
            for(int j = 0; j <c; j++){
                if(park[i].charAt(j)=='S'){
                    nr = i; nc= j;
                    // 시작위치
                    map[i][j]= 2;
                } else if(park[i].charAt(j)=='O'){
                    //길
                    map[i][j] =0;
                } else{
                    // 장애물
                    map[i][j]=1;
                }
            }
        }
        
        for(int i =0 ; i< routes.length; i++){
            char order = routes[i].charAt(0);
            int moveCnt = routes[i].charAt(2)-'0';
            int tc = nc;
            int tr = nr;
            boolean is = true;
            
            if(order=='S'){
                if(moveCnt+tr>=r) continue;
                for(int x=0;x<moveCnt; x++){
                    if(map[++tr][tc]==1){
                        is = false;
                        break;
                    }
                }
            } else if(order=='N'){
                if(tr-moveCnt<0) continue;
                for(int x=0;x<moveCnt; x++){
                    if(map[--tr][tc]==1){
                        is = false;
                        break;
                    }
                }
              } else if(order=='E'){
                if(moveCnt+tc>=c) continue;
                for(int x=0;x<moveCnt; x++){
                    if(map[tr][++tc]==1){
                        is = false;
                        break;
                    }
                }      
            } else if(order=='W'){
                if(tc-moveCnt < 0) continue;
                for(int x=0; x<moveCnt; x++){
                    if(map[tr][--tc]==1){
                        is = false;
                        break;
                    }
                }
            }
            if(is){
                nr=tr;
                nc=tc;
            }
        }
        int[] ans = {nr,nc};
        return ans;
        
    }
}