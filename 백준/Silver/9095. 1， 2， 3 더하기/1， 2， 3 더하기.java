import java.io.*;
import java.util.*;

public class Main {
	static int sum, n, a;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 n개 주어짐
		// 각 숫자를 1,2,3의 조합을 이용해서 만들 수 있는 방법이 몇개인지 찾으세요
		//
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			a = Integer.parseInt(br.readLine());
			find(0, 0);
			System.out.println(cnt);
			cnt=0;
		}
	}

	private static void find(int start, int plus) {
		if (start >= a)
			return; // start가 a보다 크거나 같다면 더이상 할 필요없기에 return

		start += plus; // start에 1,2,3을 더해서 또 더하고 ... 재귀로 반복한 후 cnt를 늘림
		if (start == a) { //정답이 됐다면 cnt를 +1 하고 return;
			cnt++;
			return;
		}

		find(start, 1);
		find(start, 2);
		find(start, 3);

	}
}
