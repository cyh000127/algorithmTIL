import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // InputStreamReader를 사용하여 바이트 단위의 입력을 문자 단위로 변환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // 한 줄씩 읽어들이며, 입력의 끝(EOF)에 도달하면 readLine()이 null을 반환
        // line이 null이 아닐 때까지 반복
        while ((line = br.readLine()) != null) {
            // 읽은 줄을 그대로 출력
            System.out.println(line);
        }
        
        // BufferedReader 닫기
        br.close();
    }
}
