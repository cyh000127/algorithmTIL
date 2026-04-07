import java.util.*;
import java.io.*;

/*
 * 4504 배수 찾기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int target = Integer.parseInt(br.readLine());
		while (true) {
			int s = Integer.parseInt(br.readLine());
			if(s==0) {
				break;
			}
			
			if (s % target != 0) {
				sb.append(s + " is NOT a multiple of "+ target+".").append("\n");
			} else {
				sb.append(s + " is a multiple of "+ target+".").append("\n");
			}
		}
		System.out.println(sb);
	}
}