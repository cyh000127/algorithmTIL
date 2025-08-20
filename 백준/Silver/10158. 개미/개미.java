import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 가로 w (x)
		// 세로 h (y)
		// 왼쪽 아래가 (0,0)
		// 개미의 위치 (p,q)
		// 1시간당 한칸 감
		// 개미는 벽을 만나면 반사됨 -> 어떻게?
		// 어떻게?????????????????????????????
		// 배열은 (y, x)임
		StringTokenizer st = new StringTokenizer(br.readLine());
		// w,h 지도 크기
		long w = Long.parseLong(st.nextToken()); // x 가로 길이 == x maximum
		long h = Long.parseLong(st.nextToken()); // y 세로 길이 == y maximum

		st = new StringTokenizer(br.readLine());
		// 개미 시작 위치
		long p = Long.parseLong(st.nextToken()); // x위치 4
		long q = Long.parseLong(st.nextToken());// y위치 1

		// 개미 이동 횟수
		long move = Long.parseLong(br.readLine());

		// 개미가 x축으로 2w시간 만큼 이동한다면 지금 시작위치로 돌아오게 됨
		long lastlocX = (p + move) % (2 * w);
		long lastlocY = (q + move) % (2 * h);
		// 지금 이 lastloc 들은 두배의 위치중 어딘가에 있음
		// 만약 lastloc가 w나 h 보다 높다면2w-lastlocX 해주면 위치가 나옴
		// 만약 lastloc가 w나 h 보다 작거나 같다면 lastlocX가 위치임

		long finalX;
		long finalY;
		if (lastlocX <= w) {
			finalX = lastlocX;
		} else {
			finalX = 2 * w - lastlocX;
		}

		if (lastlocY <= h) {
			finalY = lastlocY;
		} else {
			finalY = 2 * h - lastlocY;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(finalX).append(" ").append(finalY);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
