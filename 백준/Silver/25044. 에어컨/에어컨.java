import java.util.*;
import java.io.*;

/**
 * 25044 에어컨
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 에어컨 시계가 꺼지는 주기
		// 15 -> 18 (180분)
		// 18 -> 21 (180분)
		// 21-> 15 (1080분)
		int[] rotate = { 180, 180, 1080 };

		// 꺼지는 시간
		long nowTime = 900;
		// 횟수 카운트
		int rotateCnt = 0;

		// n일째 시작
		long targetStart = (long) n * 24 * 60;
		// n일째 끝
		long targetEnd = (long) (n + 1) * 24 * 60;

		List<String> results = new ArrayList<>();

		// target까지 while 문
		while (nowTime < targetEnd) {
			if (nowTime >= targetStart) {
				long totalMin = nowTime % (24 * 60);
				long h = totalMin / 60;
				long m = totalMin % 60;

				// 문자열 조립해서 List에 넣기
				StringBuilder timeStr = new StringBuilder();
				if (h < 10)
					timeStr.append('0');
				timeStr.append(h).append(':');
				if (m < 10)
					timeStr.append('0');
				timeStr.append(m);

				results.add(timeStr.toString());
			}

			nowTime += rotate[rotateCnt];

			if (rotateCnt == 2) {
				nowTime += k;
			}

			rotateCnt = (rotateCnt + 1) % 3;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(results.size()).append("\n");

		for (String time : results) {
			sb.append(time).append("\n");
		}
		
		System.out.print(sb);
	}
}