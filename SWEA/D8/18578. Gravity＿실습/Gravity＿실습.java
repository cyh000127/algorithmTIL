import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 T 선언
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int width = Integer.parseInt(br.readLine()); // 방 가로길이
			int[] height = new int[width];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < width; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			int maxDrop = 0;

			for (int i = 0; i < width; i++) {
				int drop = 0;
				for (int j = i + 1; j < width; j++) {
					if (height[j] < height[i]) {
						drop++;
					}
					}
				if (drop > maxDrop) {
					maxDrop = drop;
				}
			}
			System.out.println("#" +test + " "+ maxDrop);
		}
	}
}
