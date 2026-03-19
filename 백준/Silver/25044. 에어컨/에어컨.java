import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] rotate = { 180, 180, 1080 };
		long nowTime = 900;
		int rotateCnt = 0;
		long targetStart = (long) n * 24 * 60;
		long targetEnd = (long) (n + 1) * 24 * 60;
		List<String> results = new ArrayList<>();
		while (nowTime < targetEnd) {
			if (nowTime >= targetStart) {
				long totalMin = nowTime % (24 * 60);
				long h = totalMin / 60;
				long m = totalMin % 60;
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