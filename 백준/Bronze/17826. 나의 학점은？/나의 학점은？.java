import java.util.*;
import java.io.*;

/**
 * 17826 나의 학점은?
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(br.readLine());

		for (int i = 1; i <= 50; i++) {
			if (s == Integer.parseInt(st.nextToken())) {
				s = i;
				break;
			}
		}

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