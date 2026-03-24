import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 개수 입력
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] heights = new int[N];
            for (int i = 0; i < N; i++) {
                heights[i] = sc.nextInt();
            }
            
            // LIS(최장 증가 부분 수열) 길이를 구하기 위한 DP 배열
            int[] dp = new int[N];
            int maxLIS = 0;
            
            for (int i = 0; i < N; i++) {
                dp[i] = 1; // 최소 길이는 자기 자신인 1
                for (int j = 0; j < i; j++) {
                    // 이전 집(j)이 현재 집(i)보다 낮다면 증가 수열 가능
                    if (heights[j] < heights[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                // 전체 집들 중 가장 긴 증가 수열의 길이 갱신
                maxLIS = Math.max(maxLIS, dp[i]);
            }
            
            // 파괴해야 할 최소 집의 수 = 전체 개수 - 남길 수 있는 최대 개수(LIS)
            int result = N - maxLIS;
            System.out.println("Case #" + t + ": " + result);
        }
        
        sc.close();
    }
}