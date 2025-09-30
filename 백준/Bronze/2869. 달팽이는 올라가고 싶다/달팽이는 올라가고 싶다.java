import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 백준
		// 2869. 달팽이는 올라가고 싶다.

		// 낮에 A만큼 올라가고 밤에 B만큼 미끄러질 떄 며칠이 걸려야 V까지 가는지

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		// 1. 전체 길이에서 하루에 올라가는 만큼 뺸다 ( 마지막 날 )
		// 2. 그 후에 A-B를 해서 구한다.

		int v = V - A; // 마지막날을 제외한 총 올라가야하는 높이

		if (v % (A - B) > 0) {  // 나머지가 있다면 하루 더 써야함
			System.out.println(v / (A - B) + 2); 
		} else
			System.out.println(v / (A - B) + 1);

	}
}