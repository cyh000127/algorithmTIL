import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int size = Math.min(N, M); // 정사각형 최대의 경우 구하기
		boolean check = false;
		arr = new int[N][M];
		// 입력되는 직사각형 값 저장
		for (int i = 0; i < N; i++) {
			String info = br.readLine();
			for (int j = 0; j < M; j++)
				arr[i][j] = Character.getNumericValue(info.charAt(j));
		}
		while (size != 1) {

			for (int i = 0; i <= N - size; i++) {
				for (int j = 0; j <= M - size; j++)
					if (search(i, j, size - 1)) {
						check = true;
						break;
					}
				if (check)
					break;
			}
			if (check)
				break;
			size--; // 정사각형 크기 줄이기
		}
		System.out.println(size * size);
	}

	static boolean search(int y, int x, int size) {
		if (arr[y][x] == arr[y + size][x] && arr[y][x] == arr[y][x + size] && arr[y][x] == arr[y + size][x + size])
			return true;
		return false;
	}
}