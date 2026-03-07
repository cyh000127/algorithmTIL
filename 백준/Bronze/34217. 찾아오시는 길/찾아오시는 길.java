import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int H = 0;
        int Y = 0;

        for (int i = 0; i < 2; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	H += Integer.parseInt(st.nextToken());
        	Y += Integer.parseInt(st.nextToken());
        }
        
        if (H < Y) {
            System.out.println("Hanyang Univ.");
        } else if (H > Y) {
            System.out.println("Yongdap");
        } else {
            System.out.println("Either");
        }
    }
}