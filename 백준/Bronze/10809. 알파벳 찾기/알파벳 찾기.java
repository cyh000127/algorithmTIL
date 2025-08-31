import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        // 몇번째 위치에 무슨 알파벳이 있는지 셀것
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (str.charAt(i) == (char) 97 + j) {
                    if(arr[j]!= -1){
                        continue;
                    }
                    arr[j] = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}