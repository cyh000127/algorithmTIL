class Solution {
    public int solution(int n, int w, int num) {

        // num의 행, 열 구하기
        int row = (num - 1) / w;
        int col;

        if (row % 2 == 0) {
            col = (num - 1) % w;
        } else {
            col = w - 1 - ((num - 1) % w);
        }

        int answer = 1;

        // 같은 열의 위쪽 상자 검사
        for (int r = row + 1; ; r++) {

            int box;

            if (r % 2 == 0) {
                // 왼쪽 -> 오른쪽
                box = r * w + col + 1;
            } else {
                // 오른쪽 -> 왼쪽
                box = (r + 1) * w - col;
            }

            if (box > n) break;

            answer++;
        }

        return answer;
    }
}