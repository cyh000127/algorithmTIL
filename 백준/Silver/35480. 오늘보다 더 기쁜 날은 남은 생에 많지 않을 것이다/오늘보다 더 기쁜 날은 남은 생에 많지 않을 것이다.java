import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int y0 = Integer.parseInt(st.nextToken());
        int m0 = Integer.parseInt(st.nextToken());
        int d0 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[][] hosts = new int[n][3]; // [y, m, d]
        
        int todayJoy = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hosts[i][0] = Integer.parseInt(st.nextToken()); // y
            hosts[i][1] = Integer.parseInt(st.nextToken()); // m
            hosts[i][2] = Integer.parseInt(st.nextToken()); // d
            
            if (hosts[i][1] == m0 && hosts[i][2] == d0) {
                todayJoy = y0 - hosts[i][0];
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            int birthY = hosts[i][0];
            int birthM = hosts[i][1];
            int birthD = hosts[i][2];

            for (int currY = y0; currY <= y1; currY++) {
                if (isAfter(currY, birthM, birthD, y0, m0, d0) && 
                    isBeforeOrEqual(currY, birthM, birthD, y1, m1, d1)) {
                    
                    // 기쁨 수치
                    if (currY - birthY > todayJoy) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    // 날짜 비교
    private static boolean isAfter(int y, int m, int d, int targetY, int targetM, int targetD) {
        if (y > targetY) return true;
        if (y < targetY) return false;
        if (m > targetM) return true;
        if (m < targetM) return false;
        return d > targetD;
    }

    // 날짜 비교
    private static boolean isBeforeOrEqual(int y, int m, int d, int limitY, int limitM, int limitD) {
        if (y < limitY) return true;
        if (y > limitY) return false;
        if (m < limitM) return true;
        if (m > limitM) return false;
        return d <= limitD;
    }
}