import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int cut = Integer.parseInt(br.readLine());

		// 자르는 위치를 기록할 boolean 배열, 경계선 포함
		boolean[] xCuts = new boolean[X + 1];
		boolean[] yCuts = new boolean[Y + 1];

		// 종이의 시작점과 끝점을 자르는 선으로 간주
		xCuts[0] = true;
		xCuts[X] = true;
		yCuts[0] = true;
		yCuts[Y] = true;

		for (int i = 0; i < cut; i++) {
			st = new StringTokenizer(br.readLine());
			int xy = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());

			if (xy == 0) { // 가로로 자름
				yCuts[loc] = true;
			} else if (xy == 1) { // 세로로 자름
				xCuts[loc] = true;
			}
		}

		// 가장 긴 가로 길이 구하기
		int maxX = 0;
		int lastCut = 0;
		for (int i = 1; i <= X; i++) {
			if (xCuts[i]) {
				int length = i - lastCut;
				maxX = Math.max(maxX, length);
				lastCut = i;
			}
		}

		// 가장 긴 세로 길이 구하기
		int maxY = 0;
		lastCut = 0;
		for (int i = 1; i <= Y; i++) {
			if (yCuts[i]) {
				int length = i - lastCut;
				maxY = Math.max(maxY, length);
				lastCut = i;
			}
		}

		System.out.println(maxX * maxY);
	}
}