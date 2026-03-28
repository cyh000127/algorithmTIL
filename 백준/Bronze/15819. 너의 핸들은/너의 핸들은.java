import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // StringTokenizer; 입력받은 문자를 기본 delim(\t, \n 등)으로 분리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 핸들 n개
        String[] handle = new String[n];
        for(int i=0; i<n; i++){
            handle[i]=br.readLine();
        }

        // 정답 함수 호출
        System.out.println(solution(handle, k));
    }

    public static String solution(String[] handle, int k){
        Arrays.sort(handle);
        return handle[k-1];
    }
}