import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 범위 입력
        int[] hRange = new int[2];
        int[] sRange = new int[2];
        int[] vRange = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        hRange[0] = Integer.parseInt(st.nextToken());
        hRange[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sRange[0] = Integer.parseInt(st.nextToken());
        sRange[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        vRange[0] = Integer.parseInt(st.nextToken());
        vRange[1] = Integer.parseInt(st.nextToken());

        // RGB 입력
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // HSV 계산을 위한 M, m 추출
        int M = Math.max(r, Math.max(g, b));
        int m = Math.min(r, Math.min(g, b));
        double diff = M - m;

        double V = M;

        double S = (V == 0) ? 0 : (255.0 * diff / V);

        double H = 0;
        if (diff != 0) {
            if (M == r) {
                H = 60.0 * (g - b) / diff;
            } else if (M == g) {
                H = 120.0 + (60.0 * (b - r) / diff);
            } else {
                H = 240.0 + (60.0 * (r - g) / diff);
            }
        }
        
        if (H < 0) H += 360;

        
        if (H >= hRange[0] && H <= hRange[1] &&
            S >= sRange[0] && S <= sRange[1] &&
            V >= vRange[0] && V <= vRange[1]) {
            System.out.println("Lumi will like it.");
        } else {
            System.out.println("Lumi will not like it.");
        }
    }
}