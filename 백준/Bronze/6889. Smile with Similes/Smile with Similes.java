import java.util.*;
import java.io.*;

/**
 * 6321 IBM 빼기 1
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		String[] nToString = new String[n];

		for (int i = 0; i < n; i++) {
			nToString[i] = br.readLine();
		}

		String[] mToString = new String[m];

		for (int i = 0; i < m; i++) {
			mToString[i] = br.readLine();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(nToString[i]+" as "+mToString[j]+"\n");
			}
		}
		System.out.println(sb);
	}
}