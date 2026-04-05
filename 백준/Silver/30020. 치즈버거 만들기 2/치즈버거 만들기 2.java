import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt(); // 패티 개수
        int B = sc.nextInt(); // 치즈 개수
        
        // 치즈버거 개수 K는 패티와 치즈의 차이와 같아야 함
        int K = A - B;
        
        // 1. 패티가 치즈보다 많아야 함 (K > 0)
        // 2. 각 버거마다 최소 1개의 치즈가 필요하므로 치즈 총량 B는 K보다 크거나 같아야 함
        if (K > 0 && B >= K) {
            System.out.println("YES");
            System.out.println(K);
            
            // K-1개까지는 가장 작은 단위인 "aba" (패티 2, 치즈 1)를 출력
            for (int i = 0; i < K - 1; i++) {
                System.out.println("aba");
                A -= 2;
                B -= 1;
            }
            
            // 남은 모든 패티와 치즈를 마지막 버거에 몰아서 출력
            // 마지막 버거도 패티가 치즈보다 1개 많은 상태가 유지됨
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < B; i++) {
                sb.append("ab");
            }
            sb.append("a");
            System.out.println(sb.toString());
            
        } else {
            System.out.println("NO");
        }
        
        sc.close();
    }
}