import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 지정
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {

			// 지도 크기 N
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];
			// 지도에 값 할당
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 방향 벡터 설정
			int[] dr = { -1,0,1,0 };
			int[] dc = { 0,1,0,-1 };
			int cnt =0; // 봉우리 개수 저장
			
			for(int i=0; i<N; i++) {
				for(int j =0; j<N; j++) {
					boolean isPeek = true;
					for(int d = 0; d<4; d++) {
						// 조건을 벗어나는 경우는 continue;
						if((i+dr[d])<0 ||(i+dr[d])>=N||(j+dc[d])<0||(j+dc[d])>=N) continue;
						int nr = i + dr[d];
						int nc = j + dc[d];
						// 주변보다 하나라도 낮으면 봉우리가 아님
						if(arr[i][j] <= arr[nr][nc]) {
							isPeek = false;
							break;
						}
					}

					if(isPeek) cnt++;
				}
			}
			System.out.println("#"+test+" "+cnt);
		}
	}
}
