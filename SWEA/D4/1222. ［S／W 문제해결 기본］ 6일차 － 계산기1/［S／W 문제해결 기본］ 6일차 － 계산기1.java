import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test = 1; test <= 10; test++) {
			
			int length = sc.nextInt();
			String plus = sc.next();
			
			int sum = 0;
			int[] arr = new int[length];
			for (int i = 0; i < length; i++) {
				if (plus.charAt(i) != '+') {
					arr[i] = (int) plus.charAt(i) - '0';
				}
			}
			// 길이만큼 배열에서 꺼내서 싹 다더해
			for (int i = 0; i < length; i++) {
				sum += arr[i];
			}
			System.out.println("#" + test + " " + sum);

		}
	}
}
