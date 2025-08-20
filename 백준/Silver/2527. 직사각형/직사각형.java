import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력이 8개 주어지는데
		// 첫번째 왼쪽 아래 꼭의 x,y 좌표
		// 첫번째 오른쪽 위 꼭의 x,y 좌표

		// 두번째 왼쪽 아래 꼭의 x,y 좌표
		// 두번째 오른쪽 위 꼭의 x,y 좌표

		// 두 사각형이 겹치는 경우 a
		// 맞닿는 경우 b
		// 꼭짓점만 닿은 경우 c
		// 겹치지 않는 경우 d
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			int x = Math.min(Math.abs(p2 - x1), Math.abs(x2 - p1));
			int y = Math.min(Math.abs(q2 - y1), Math.abs(y2 - q1));

			if (x == 0 && y == 0) {
				System.out.println('c');
			} else if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
				// 아무 범위에도 해당하지 않는다면 두 직사각형은 떨어져있는것
				System.out.println('d');
			} else if (x > 0 && y > 0) {
				System.out.println('a');
			} else if ((x > 0 && y == 0) || (y > 0 && x == 0)) {
				System.out.println('b');
			}

		}

	}
}
