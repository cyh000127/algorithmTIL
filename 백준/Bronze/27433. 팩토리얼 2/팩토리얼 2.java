import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long a = 1;
		int s = Integer.parseInt(br.readLine());

		while (s > 1) {
			a *= s--;
		}
		System.out.println(a);
	}
}
