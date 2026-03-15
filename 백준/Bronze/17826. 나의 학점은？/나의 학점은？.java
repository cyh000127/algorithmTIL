import java.util.*;
import java.io.*;

/**
 * 17826 나의 학점은?
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] g = new int[301];
		for (int i = 1; i <= 50; i++) {
			g[Integer.parseInt(st.nextToken())] = i;
		}

		int s = g[Integer.parseInt(br.readLine())];

		if (s <= 5) {
			System.out.println("A+");
		} else if (s <= 15) {
			System.out.println("A0");
		} else if (s <= 30) {
			System.out.println("B+");
		} else if (s <= 35) {
			System.out.println("B0");
		} else if (s <= 45) {
			System.out.println("C+");
		} else if (s <= 48) {
			System.out.println("C0");
		} else if (s <= 50) {
			System.out.println("F");
		}

	}
}