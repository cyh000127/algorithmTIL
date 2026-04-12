import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 값이 없을 경우를 대비한 체크 (선택 사항)
        if (!sc.hasNextInt()) {
            return;
        }
        
        int n = sc.nextInt();
        
        if (n < 3) {
            System.out.print(4);
        } else {
            for (int i = 2; i < n; i++) {
                if (n <= (long)i * i) {
                    System.out.print((i - 1) * 4);
                    break;
                } else if (n <= (long)i * (i + 1)) {
                    System.out.print((i - 1) * 4 + 2);
                    break;
                }
            }
        }
        
        sc.close();
    }
}