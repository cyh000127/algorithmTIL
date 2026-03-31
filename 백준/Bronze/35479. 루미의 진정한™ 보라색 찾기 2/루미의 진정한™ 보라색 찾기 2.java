import java.util.*;
import java.io.*;

/**
 * 16967 배열 복원하기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		double rp = (double)R / 255.0;
		double gp = (double)G / 255.0;
		double bp = (double)B / 255.0;

		double maxRGB = Math.max(rp, Math.max(gp, bp));
		double K = 1.0 - maxRGB;

		double C, M, Y;

		// C, M, Y 계산
		if (K == 1.0) {
			C = 0.0;
			M = 0.0;
			Y = 0.0;
		} else {
			C = (1.0 - rp - K) / (1.0 - K);
			M = (1.0 - gp - K) / (1.0 - K);
			Y = (1.0 - bp - K) / (1.0 - K);
		}

		System.out.printf("%.9f %.9f %.9f %.9f\n", C, M, Y, K);

	}
}
