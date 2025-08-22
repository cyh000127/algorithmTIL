import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			int score = 0;
			int CC = 1;
			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'O') {
					score += CC++;
				} else if (str.charAt(i) == 'X') {
					CC = 1;
				}
			}
			System.out.println(score);
		}

	}
}