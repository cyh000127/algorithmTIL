import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test = 1 ; test<=T; test++) {
            StringBuilder sb = new StringBuilder();
            String a = br.readLine();
            sb.append(a.charAt(0));
            sb.append(a.charAt(a.length()-1));
            System.out.println(sb.toString());
        }


    }
}