import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String S = br.readLine(); // 주어진 문자열
        int N = Integer.parseInt(br.readLine()); //질문의 수

        while(N --> 0) { //질문 개수만큼 반복
            st = new StringTokenizer(br.readLine());
            char findChar = st.nextToken().charAt(0); //찾으려는 문자
            int start = Integer.parseInt(st.nextToken()); //찾으려는 범위의 시작점
            int end = Integer.parseInt(st.nextToken()); //찾으려는 범위의 끝점

            int count = 0; //찾으려는 문자가 범위 내에 몇개 있는지 카운트하는 변수

            if(S.indexOf(findChar) >= 0){ //만약 찾으려는 문자가 포함되어 있으면 (문자열에)
                for(int i = start; i <= end; i++){
                    if(findChar == S.charAt(i)){ //만약 찾으려는 문자이면
                        count++; //카운트 + 1
                    }
                }
            }
            bw.write(count+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

}