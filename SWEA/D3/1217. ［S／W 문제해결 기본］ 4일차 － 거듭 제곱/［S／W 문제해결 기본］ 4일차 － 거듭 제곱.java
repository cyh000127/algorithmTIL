import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 총 10개의 테스트 케이스를 처리
        for (int i = 1; i <= 10; i++) {
            int testCase = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            // 재귀 함수 호출하여 결과 계산
            int result = power(N, M);
            
            // 형식에 맞춰 결과 출력
            System.out.println("#" + testCase + " " + result);
        }
        sc.close();
    }
    
    // 재귀를 이용한 거듭제곱 함수
    public static int power(int base, int exp) {
        // 종료 조건: 지수(exp)가 0이 되면 1을 반환
        if (exp == 0) {
            return 1;
        }
        
        // 재귀 호출: base * power(base, exp-1)
        return base * power(base, exp - 1);
    }
}