import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // N개의 숫자 카드 개수 입력
        int N = Integer.parseInt(br.readLine());
        
        // HashMap을 사용하여 상근이의 카드 개수를 카운트
        HashMap<Integer, Integer> cardCounts = new HashMap<Integer, Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            // getOrDefault를 사용하여 카드가 이미 존재하면 개수를 1 증가 / 없으면 1 감소
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }
        
        // 정수 개수 M
        int M = Integer.parseInt(br.readLine());
        
        // 상근이의 보유 현황 계산 
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            // getOrDefault를 사용하여 숫자가 없다면  0 반환
            sb.append(cardCounts.getOrDefault(number, 0)).append(" ");
        }
        
        bw.write(sb.toString().trim());
        bw.flush();
        br.close();
        bw.close();
    }
}