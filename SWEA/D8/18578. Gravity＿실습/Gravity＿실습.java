import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내가 이겼어 
// 2차원 배열을 사용한 내가 이겻어
// 구닥다리 코드여도 괜찮아 내가 이겼어 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 T 선언
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			// 가로 크기 n
			int n = Integer.parseInt(br.readLine());

			// 애초에 돌린 후의 배열 선언
			int[][] arr = new int[n][100];
			int A = 0;

			// 블럭 쌓음
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			for (int i = 0; i < n; i++) {
				int token = Integer.parseInt(st.nextToken());
				A = Math.max(A, token);

				// 쌓을 블럭이 없으면 넘어감
				if (token == 0)
					continue;
				
				// 블럭이 쌓일 위치에 1을 넣음
				for (int j = 0; j < token; j++) {
					arr[i][j] = 1;
				}
			}
			int maxDrop = 0;

			for (int i = 0; i < n; i++) {
			    int height = 0;
			    for (int j = 0; j < 100; j++) {
			        if (arr[i][j] == 1) {
			            height++;
			        } else {
			            break;
			        }
			    }

			    int drop = 0;
			    for (int j = i + 1; j < n; j++) {
			        int nextHeight = 0;
			        for (int k = 0; k < 100; k++) {
			            if (arr[j][k] == 1) {
			                nextHeight++;
			            } else {
			                break;
			            }
			        }
			        if (height > nextHeight) {
			            drop++;
			        }
			    }
			    maxDrop = Math.max(maxDrop, drop);
			}
			System.out.println("#" + test + " " + maxDrop);
		}
	}
}
