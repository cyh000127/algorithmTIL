class Solution {
    public int solution(String[][] board, int h, int w) {

        // 상하좌우 같은 색으로 칠해진 칸의 개수를 구한다 ?

        // board 시작위치 h, w 가 주어질때 

        int[] dr = {0, 1, -1, 0};
        int[] dc = {1,0,0,-1};

        String target = board[h][w];
        
        int ans = 0;
        for(int d = 0; d<4; d++){
            int nr = h +dr[d];
            int nc = w +dc[d];
            
            if(nr <0 || nc< 0 || nr>=board.length || nc>= board.length){
                continue;
            }
            
            if(board[nr][nc].equals(target)) ans++;
        }
        
        return ans;
    }
}