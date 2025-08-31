import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0; // n번째를 찾기 위한 카운터
        int num = 665; // 666부터 검사를 시작하기 위한 초기값

        // count가 n과 같아질 때까지 무한 반복
        while (count < n) {
            num++; // 숫자를 1씩 증가시킨다 (666, 667, 668...)

            // 현재 숫자를 문자열로 변환하고 "666"을 포함하는지 확인한다.
            if (String.valueOf(num).contains("666")) {
                count++; // 포함한다면 카운터를 1 증가시킨다.
            }
        }

        // n번째 종말의 숫자를 출력한다.
        System.out.println(num);
    }
}