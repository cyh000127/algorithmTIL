import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int result = 0;

        for (int i = 1; i < N; i++) {
            int sum = i;
            int num = i;

            // 각 자리수의 합을 계산
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            // 분해합이 N과 같은지 확인
            if (sum == N) {
                result = i;
                break; // 가장 작은 생성자를 찾았으므로 반복문 종료
            }
        }
        System.out.println(result);
    }
}