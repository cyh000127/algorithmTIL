import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 한번에 하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 개수(T)를 읽어옵니다.
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            // 이용권 요금 (1일, 1달, 3달, 1년 순서)
            int[] fees = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                fees[i] = Integer.parseInt(st.nextToken());
            }

            // 12개월 이용 계획
            int[] plan = new int[12];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            // DP 배열: dp[i]는 i월까지의 최소 누적 비용을 저장합니다.
            // 크기를 13으로 하여 인덱스 1~12를 사용하고, dp[0]은 0으로 시작합니다.
            int[] dp = new int[13];

            // 1월부터 12월까지 순회하며 각 월까지의 최소 비용을 계산합니다.
            for (int i = 1; i <= 12; i++) {
                // 선택 1: 1일권 또는 1달권을 사용하는 경우
                // (i-1)월까지의 최소 비용 + min(i월 이용일수 * 1일권, 1달권)
                // plan 배열은 0-indexed이므로 plan[i-1]을 사용합니다.
                int costOpt1 = dp[i-1] + Math.min(plan[i-1] * fees[0], fees[1]);

                // 선택 2: 3달 이용권을 사용하는 경우 (3월 이상부터 가능)
                int costOpt2 = Integer.MAX_VALUE; // 비교를 위해 기본값을 최댓값으로 설정
                if (i >= 3) {
                    // (i-3)월까지의 최소 비용 + 3달권 요금
                    costOpt2 = dp[i-3] + fees[2];
                }
                
                // 두 가지 선택 중 더 저렴한 비용을 dp[i]에 저장합니다.
                dp[i] = Math.min(costOpt1, costOpt2);
            }

            // 1일/1달/3달권 조합의 연간 최소 비용(dp[12])과 1년권 비용(fees[3])을 최종 비교합니다.
            int minCost = Math.min(dp[12], fees[3]);

            // 형식에 맞게 출력 문자열을 구성합니다.
            sb.append("#").append(test_case).append(" ").append(minCost).append("\n");
        }

        // 모든 테스트 케이스의 결과를 한번에 출력합니다.
        System.out.print(sb.toString());
    }
}