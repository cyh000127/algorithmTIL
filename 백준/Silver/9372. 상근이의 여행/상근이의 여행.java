import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
		// 백준
		// 9372. 상근이의 여행

		// N개국을 여행
		// 비행 스케줄이 주어졌을 때 가장 적은 횟수의 비행기를 타고 여행
		// 이미 방문한 다른 국가로 가도 됨

        int T = Integer.parseInt(st.nextToken());
      
       	while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
          
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
            }
            System.out.println(N - 1);
        }
    }
}