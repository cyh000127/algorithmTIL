import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2929 머신 코드
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = br.readLine();
		int ans = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				int currentPos = i + ans;

				if (currentPos % 4 != 0) {
					int padding = 4 - (currentPos % 4);
					ans += padding;
				}
			}
		}

		System.out.println(ans);
	}
}