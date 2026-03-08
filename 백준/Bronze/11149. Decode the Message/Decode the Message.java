import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 알파벳 소문자 + 공백을 포함한 기준 문자열
        String alpa = "abcdefghijklmnopqrstuvwxyz ";

        // 테스트 케이스 개수 입력
        if (sc.hasNextInt()) {
            int t = Integer.parseInt(sc.nextLine());

            while (t-- > 0) {
                if (!sc.hasNextLine()) break;
                
                String line = sc.nextLine();
                String[] words = line.split(" ");
                StringBuilder res = new StringBuilder();

                for (String word : words) {
                    if (word.isEmpty()) continue;
                    // decode 로직 적용 후 결과 문자 추가
                    res.append(alpa.charAt(decode(word)));
                }
                
                // 최종 결과 출력
                System.out.println(res.toString());
            }
        }
        sc.close();
    }

    public static int decode(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n += s.charAt(i) - 'a';
        }
        return n % 27;
    }
}