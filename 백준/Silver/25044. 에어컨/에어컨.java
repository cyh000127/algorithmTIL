import java.util.*;
import java.io.*;

/**
 * 25044 에어컨
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] rotate = { 180, 180, 1080 };
        long targetStart = (long) n * 1440;
        long targetEnd = (long) (n + 1) * 1440;
        int count = 0;
        long nowTime = 900;
        int rotateCnt = 0;
        while (nowTime < targetEnd) {
            if (nowTime >= targetStart) {
                count++;
            }
            nowTime += rotate[rotateCnt];
            if (rotateCnt == 2) nowTime += k;
            rotateCnt = (rotateCnt + 1) % 3;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");

        char[] timeToChar = new char[5];
        timeToChar[2] = ':';

        nowTime = 900;
        rotateCnt = 0;
        
        while (nowTime < targetEnd) {
            if (nowTime >= targetStart) {
                int time = (int) (nowTime % 1440);
                int h = time / 60;
                int m = time % 60;

                timeToChar[0] = (char) (h / 10 + '0');
                timeToChar[1] = (char) (h % 10 + '0');
                timeToChar[3] = (char) (m / 10 + '0');
                timeToChar[4] = (char) (m % 10 + '0');

                sb.append(timeToChar).append('\n');
            }
            nowTime += rotate[rotateCnt];
            if (rotateCnt == 2) nowTime += k;
            rotateCnt = (rotateCnt + 1) % 3;
        }

        System.out.print(sb);
    }
}