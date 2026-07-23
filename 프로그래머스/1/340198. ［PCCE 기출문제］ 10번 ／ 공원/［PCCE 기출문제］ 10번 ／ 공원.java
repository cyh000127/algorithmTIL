import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);

        int rows = park.length;
        int cols = park[0].length;

        // 큰 돗자리부터 확인
        for (int m = mats.length - 1; m >= 0; m--) {
            int size = mats[m];

            for (int r = 0; r + size <= rows; r++) {
                for (int c = 0; c + size <= cols; c++) {

                    boolean possible = true;

                    // 영역 전체 검사
                    outer:
                    for (int i = r; i < r + size; i++) {
                        for (int j = c; j < c + size; j++) {
                            if (!park[i][j].equals("-1")) {
                                possible = false;
                                break outer;
                            }
                        }
                    }

                    if (possible) {
                        return size;
                    }
                }
            }
        }

        return -1;
    }
}