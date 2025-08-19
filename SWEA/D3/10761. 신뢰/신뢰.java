import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int move = Integer.parseInt(st.nextToken());

			int B_loc = 1;
			int O_loc = 1;

			int B_time = 0;
			int O_time = 0;

			int minTime =0 ;
			
			for(int i =0 ; i<move; i++) {
				String Target = st.nextToken();
				int target_loc = Integer.parseInt(st.nextToken());
				if(Target.equals("B")) {
					int moveloc = Math.abs(B_loc - target_loc);
					int movetime = B_time + moveloc;
					minTime = Math.max(minTime, movetime);
					minTime++;
					
					B_loc = target_loc;
					B_time = minTime;
					
					
				}
				else if(Target.equals("O")) {
					int moveloc = Math.abs(O_loc - target_loc);
					int movetime = O_time + moveloc;
					minTime = Math.max(minTime, movetime);
					minTime++;
					
					O_loc = target_loc;
					O_time = minTime;
					
					
				}
				
			}
			System.out.println("#"+test + " "+minTime);
		}
	}
}