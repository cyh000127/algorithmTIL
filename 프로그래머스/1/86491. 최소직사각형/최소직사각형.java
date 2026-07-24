import java.util.*;
import java.io.*;


class Solution {
    public int solution(int[][] sizes) {
        // 지갑 크기 정함
        // 가로 세로 n가지가 있음
     
        
        int leng = sizes.length;
        for(int i=0; i<leng; i++){
            Arrays.sort(sizes[i]);
        }

        int max = 0;
        int min = 0;
        for(int i =0 ; i<leng; i++){
          min =  Math.max(min,sizes[i][0]);
          max =  Math.max(max, sizes[i][1]);
        
        }
        
        
        return min * max;
    }
}