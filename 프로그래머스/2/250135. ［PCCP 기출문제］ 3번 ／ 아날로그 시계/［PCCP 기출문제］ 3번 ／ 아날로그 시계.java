class Solution {
    public int solution(int h1, int m1, int s1,int h2, int m2, int s2) {
        
        int answer = countUntil(h2, m2, s2) - countUntil(h1, m1, s1);

        // 시작 시각에 초침과 분침이 겹쳐 있으면 포함
        if (m1 == 0 && s1 == 0) {
            answer++;
        }

        return answer;
    }

    private int countUntil(int h, int m, int s) {
        int time = h * 3600 + m * 60 + s;

        int secondMinute = time * 59 / 3600;
        int secondHour = time * 719 / 43200;

        int count = secondMinute + secondHour;

        if (time >= 43200) {
            count--;
        }

        return count;
    }
}

