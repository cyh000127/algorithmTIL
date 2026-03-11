import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String str = br.readLine();
			int a = str.length();
			if(a>=6 &&a<=9) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
		}
	}
}
