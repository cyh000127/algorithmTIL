import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 직사 각형 네개의 위치가 주어지는데
		// 직사각형들이 차지하는 면접의 총 합을 구하여라
		// 처음 두 정수는 사각형의 왼쪽 아래의 (x,y)
		// 세번째와 네번째의 정수는 사각형의 오른쪽 위의 (x,y)
		// 사각형의 넓이는 (x34 -x12)*(y34-y12) 이다

		// x1,y1 == 왼쪽 아래
		// x2, y2 == 오른쪽 위
		int x1, y1, x2, y2;

		// 2차원 배열을 만들어서 x1 ~ x2 까지 1로 채우게 할까 ?
		int[][] arr = new int[101][101];

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());

			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					arr[x][y] = 1;
				}
			}

		}

		int ans = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (arr[i][j] == 1)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
