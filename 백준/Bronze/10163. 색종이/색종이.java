import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N장의 색종이를 펼쳐 놓았을때 보이는 부분의 크기를 구하여라
		// 각각이 보이는 넓이를 구하여야함
		// -> N장이 주어지면 답이 N개 나와야함
		// 겹치는 부분 (중복)은 세지 않음

		// 첫 입력 = 색종이 수 N
		int N = Integer.parseInt(br.readLine());

		// 색종이의 최대 크기는 1001, 1001
		// 다음 입력부터 네 개의 숫자가 주어짐
		// 처음 두개의 숫자 (x,y) 0,0이 왼쪽 아래임
		// 다음 두개의 숫자는 너비(x길이) , 높이(y길이)임

		int[][] arr = new int[101][101];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			// 길이 너비
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 겹치는건 덮어 씌우게 idx 삽입
			for (int x = x1; x < x2+x1; x++) {
				for (int y = y1; y < y2+y1; y++) {
					arr[x][y] = i;
				}
			}
		}
		
		// 각 숫자 개수 세기
		int[] ans = new int[N+1];
		for (int A = 1; A <= N; A++) {
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if(arr[i][j] == A)
						ans[A]++;
				}
			}

		}
 
		for(int i =1 ; i<=N; i++) {
			
			System.out.println(ans[i]);
		}

	}
}
