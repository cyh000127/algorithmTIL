import java.util.*;
import java.io.*;

/**
 * 1259 팰린드롬수
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		while (true) {
			String str = br.readLine();
			boolean check = true;
			if (str.equals("0"))
				break;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i))
					check = false;
			}
			if (check)
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}