import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;

		int a = Integer.parseInt(br.readLine());

		if (a % 5 == 0) {
			System.out.println(a / 5);
		} else {
			System.out.println(a / 5 + 1);
		}
	}
}
