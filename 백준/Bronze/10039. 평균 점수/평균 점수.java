import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 10039. 평균점수

		int totalScore = 0;
		
		for(int i =0  ; i<5; i++) {
			int now =  Integer.parseInt(br.readLine());
			if(now < 40) now = 40;
			totalScore +=now;
		}
		
		System.out.println(totalScore/5);

	}
}
