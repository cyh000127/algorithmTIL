import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		br.readLine(); // 내 구현에서는 자릿수는 필요없음
		String N = br.readLine();

		int sumAll = 0;
		for (int i = 0; i < N.length(); i++) {
			sumAll += N.charAt(i) - '0';
		}
		System.out.println(sumAll);

	}
}