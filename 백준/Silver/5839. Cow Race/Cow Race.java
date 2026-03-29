import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Bessie의 구간 수
        int M = sc.nextInt(); // Elsie의 구간 수

        // 최대 전체 시간은 N, M 구간의 시간 합 (최대 1,000,000)
        // 각 시간 t에서의 위치를 저장할 배열
        int[] bessiePos = new int[1000001];
        int[] elsiePos = new int[1000001];

        // Bessie 경로 계산
        int currentTime = 1;
        for (int i = 0; i < N; i++) {
            int speed = sc.nextInt();
            int time = sc.nextInt();
            for (int j = 0; j < time; j++) {
                bessiePos[currentTime] = bessiePos[currentTime - 1] + speed;
                currentTime++;
            }
        }
        int totalTime = currentTime - 1;

        // Elsie 경로 계산
        currentTime = 1;
        for (int i = 0; i < M; i++) {
            int speed = sc.nextInt();
            int time = sc.nextInt();
            for (int j = 0; j < time; j++) {
                elsiePos[currentTime] = elsiePos[currentTime - 1] + speed;
                currentTime++;
            }
        }

        // 선두 교체 횟수 계산
        int leadershipChanges = 0;
        int currentLeader = 0; // 0: 동점, 1: Bessie, 2: Elsie

        for (int t = 1; t <= totalTime; t++) {
            if (bessiePos[t] > elsiePos[t]) {
                // Bessie가 앞서고 있을 때
                if (currentLeader == 2) {
                    leadershipChanges++;
                }
                currentLeader = 1;
            } else if (elsiePos[t] > bessiePos[t]) {
                // Elsie가 앞서고 있을 때
                if (currentLeader == 1) {
                    leadershipChanges++;
                }
                currentLeader = 2;
            }
            // 위치가 같을 경우(bessiePos[t] == elsiePos[t])는 
            // 이전에 정해진 currentLeader를 유지하여 다음 추월 시 판단 근거로 삼음
        }

        System.out.println(leadershipChanges);
        sc.close();
    }
}