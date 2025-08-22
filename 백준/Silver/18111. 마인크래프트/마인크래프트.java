import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// * 문제
		// 1. (i,j)의 가장 높이 있는 블럭 인벤에 넣기 -- 소요시간 2초
		// 2. 인벤의 블럭을 꺼내 (i, j)에 놓는다. -- 소요시간 1초

		// ! 목적
		// 땅 고르기 작업의 최소 소요시간과 땅의 높이를 구하시오

		// ? 조건
		// 집터 아래에 빈공간 x
		// 땅의 높이는 256을 초과할 수 없음 + 음수도 안됨

		// 세로 N(y), 가로 M(x) , 처음 인벤토리의 블록 B
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int minHeight = 257;
		int maxHeight = -1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				if (a < minHeight) {
					minHeight = a;
				}
				if (a > maxHeight) {
					maxHeight = a;
				}
			}
		}

		int minTime = Integer.MAX_VALUE;
		int ansHeight = 0;

		// 가능한 모든 높이(0 ~ 256)를 탐색
		for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {
			int digTime = 0;
			int pileupTime = 0;
			int inventory = B;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int diff = arr[i][j] - targetHeight;
					if (diff > 0) { // 파내기
						digTime += diff * 2;
						inventory += diff;
					} else if (diff < 0) { // 쌓기
						pileupTime += -diff;
						inventory += diff; // inventory -= -diff; 와 같음
					}
				}
			}

			if (inventory >= 0) { // 인벤토리에 블록이 충분한 경우
				int totalTime = digTime + pileupTime;
				if (totalTime <= minTime) { // 최소 시간 갱신 (시간이 같으면 더 높은 높이 선택)
					minTime = totalTime;
					ansHeight = targetHeight;
				}
			}
		}

		System.out.println(minTime + " " + ansHeight);
	}
}