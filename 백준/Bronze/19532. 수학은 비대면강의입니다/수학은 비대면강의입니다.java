import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // a,b,c,d,e,f 가 순서대로 주어짐
        // 연립방적식은
        // ax + by = c
        // dx + ey = f
        // x, y를 구하시오
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int x =0;
        int y= 0;
        boolean find = false; // 찾으면 true
        while (!find) {
            for (x = -999; x < 1000; x++) {
                for (y = -999; y < 1000; y++) {
                    if (a * x + b * y == c && d * x + e * y == f) {
                        find = true;
                        break;
                    }
                }
                if (find) break;
            }

        }
        System.out.println(x+ " "+y);
    }
}