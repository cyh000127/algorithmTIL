import java.util.*;
import java.io.*;

/*
 * 루미와 블록 쌓기 게임
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 10칸, 20칸 사각 격자
		// 여러가지 블록을 원하는대로 놓음

		// 정사각형을 변끼리 연결한 모양

		// 가로줄의 10칸을 모두 채우면 안됨

		// 아래처럼 패턴을 만들면 GM 을 받음

		// 아래부터 k개의 줄까지 일치하고
		// k번째줄의 빈칸이 바로 위칸?

		char[][] arr = new char[20][10];

		for (int i = 19; i >= 0; i--) {
			arr[i] = br.readLine().toCharArray();
		}

		int cnt = 0;
		boolean ok = true;

		for (int i = 0; i < 19; i++) {
			int targetDot = (i < 10) ? i : 18 - i;

			for (int j = 0; j < 10; j++) {
				if (j == targetDot) {
					if (arr[i][j] != '.')
						ok = false;
				} else {
					if (arr[i][j] != '#')
						ok = false;
				}
				if (!ok)
					break;
			}

			if (!ok)
				break;

			cnt++;

			if (i < 18 && arr[i + 1][targetDot] != '#') {
				cnt = i;
				ok = false;
				break;
			}
		}

		if (cnt == 19) {
			if (arr[19][0] == '#') {
				System.out.println("GM");
			} else {
				System.out.println("S9");
			}
		} else if (cnt >= 10) {
			System.out.println("S" + (cnt - 9));
		} else if (cnt == 0) {
			System.out.println("X");
		} else {
			System.out.println(10 - cnt);
		}
	}
}