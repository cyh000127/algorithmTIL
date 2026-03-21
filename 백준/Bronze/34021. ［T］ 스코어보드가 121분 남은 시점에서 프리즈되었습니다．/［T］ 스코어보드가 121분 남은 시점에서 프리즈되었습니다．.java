import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            // 초기 최솟값 설정 (m - l)
            int minTime = m - l;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
          
                if (val >= 0 && val <= m) {
                    if (val < minTime) {
                        minTime = val;
                    }
                }
            }

            int res = m - minTime;
            String unit = (res == 1) ? "minute" : "minutes";
            
            sb.append("The scoreboard has been frozen with ")
              .append(res)
              .append(" ")
              .append(unit)
              .append(" remaining.\n");
        }

        System.out.print(sb.toString());
    }
}