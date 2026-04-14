import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 사람 수 N 입력
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // 2. N명의 이름 입력 받기
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        String birthdayPerson = "";

        // 3. 각 사람에 대해 최대 2번씩 질문
        for (int i = 0; i < n; i++) {
            String currentName = names[i];
            
            // 첫 번째 질문
            System.out.println("? " + currentName);
            System.out.flush();
            int firstResponse = sc.nextInt();

            // 두 번째 질문
            System.out.println("? " + currentName);
            System.out.flush();
            int secondResponse = sc.nextInt();

            // 인터랙터는 최대 1번만 거짓말을 함.
            // 만약 해당 사람이 생일이라면, (1, 1) 혹은 (0, 1) 혹은 (1, 0)이 나옴.
            // 즉, 두 응답의 합이 1 이상이면 그 사람이 생일자임.
            if (firstResponse + secondResponse >= 1) {
                birthdayPerson = currentName;
                break;
            }
        }

        // 4. 정답 출력
        System.out.println("! " + birthdayPerson);
        System.out.flush();
        
        sc.close();
    }
}