import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 단어를 읽어옴
        String word = br.readLine();

        int totalTime = 0; // 총 시간을 저장할 변수

        // 단어의 길이만큼 반복
        for (int i = 0; i < word.length(); i++) {

            // 단어의 각 문자를 하나씩 확인
            char c = word.charAt(i);

            // switch 문을 사용하여 각 문자에 해당하는 시간을 더함
            switch (c) {
                case 'A': case 'B': case 'C':
                    totalTime += 3; // 숫자 2는 3초
                    break;

                case 'D': case 'E': case 'F':
                    totalTime += 4; // 숫자 3은 4초
                    break;

                case 'G': case 'H': case 'I':
                    totalTime += 5; // 숫자 4는 5초
                    break;

                case 'J': case 'K': case 'L':
                    totalTime += 6; // 숫자 5는 6초
                    break;

                case 'M': case 'N': case 'O':
                    totalTime += 7; // 숫자 6은 7초
                    break;

                case 'P': case 'Q': case 'R': case 'S':
                    totalTime += 8; // 숫자 7은 8초
                    break;

                case 'T': case 'U': case 'V':
                    totalTime += 9; // 숫자 8은 9초
                    break;

                case 'W': case 'X': case 'Y': case 'Z':
                    totalTime += 10; // 숫자 9는 10초
                    break;
            }
        }

        // 최종적으로 계산된 총 시간을 출력
        System.out.println(totalTime);
    }
}