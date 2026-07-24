import java.util.*;
import java.io.*;


class Solution {

    static int[] dr = { 0, -1, 1, 0};
    static int[] dc = {-1, 0, 0, 1};
    static int[][] map;
    static int mapr, mapc;

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        // 한번에 하나씩
        // 회전 가능
        // 뒤집을 수 없음
        //새로 넣은 조각과 인접 칸이 비어있으면 안됨

        // 1. 보드 bfs 해서 칸들 개수 찾은 후
        // 2. 칸에 맞는 블럭 가져와서 들어가는지 체크
        // 3. 되면 카운트 

        // - - 
        // + -
        // + +
        // - + 
        mapr= game_board.length;
        mapc =game_board[0].length;
        map = new int[mapr][mapc];
        for(int i= 0 ; i<mapr; i++){
            Arrays.fill(map[i],-1);
        }
        
        create_map(game_board);
        
        
        return answer;
    }

    public void create_map(int[][] gameboard){
        boolean[][] visited = new boolean[mapr][mapc];
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> qq = new ArrayDeque<>();
        
        // 이동경로를 tmp로 저장하고
        // 넓이 계산 후 tmp 위치에 cnt를 넣기 ? 

        for(int i =0 ; i<mapr; i++){
            for(int j = 0; j<mapc; j++){
                if(gameboard[i][j]==0 && !visited[i][j]){
                    q.add(new int[]{i,j});
                    int count =0;
                    
                    while(!q.isEmpty()){
                       int[] now =  q.poll();
                       int rr= now[0];
                        int cc= now[1];
                        
                        for(int d = 0; d<4; d++){
                        int nr= rr+dr[d];
                        int nc =cc+dc[d];
                        
                        if(nr<0 || nc<0 || nr>=mapr || nc>= mapc){
                            continue;
                        }
                            
                        if(gameboard[nr][nc] == 0 &&  !visited[nr][nc]){
                            q.add(new int[]{nr,nc});
                            qq.add(new int[]{nr,nc});
                            visited[nr][nc] =true;
                            count++; 
                        }
                    }
                    }
                    
                    while(!qq.isEmpty()){
                        int[] tmp = qq.poll();
                        map[tmp[0]][tmp[1]]= count;
                    }
                }
            }
        }
        return;
    }
}