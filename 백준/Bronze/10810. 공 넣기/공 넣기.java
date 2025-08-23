import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] baskets = new int[N]; // N개의 바구니 배열 (인덱스 0부터 N-1)

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // i번부터 j번 바구니까지 k번 공 넣기
            for (int currentBasket = i - 1; currentBasket < j; currentBasket++) {
                baskets[currentBasket] = k;
            }
        }

        // 결과 출력을 위한 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (int basket : baskets) {
            sb.append(basket).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}