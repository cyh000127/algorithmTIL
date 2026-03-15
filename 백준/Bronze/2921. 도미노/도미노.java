import java.util.*;
import java.io.*;

/**
 * 2921 도미노
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());

		int x = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				x++;
			}
		}
		System.out.println(x*n);
	}
}