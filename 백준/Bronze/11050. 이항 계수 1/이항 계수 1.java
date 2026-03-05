import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //n
        int k = Integer.parseInt(st.nextToken()); //k

        //이항 계수 구하는 공식
        System.out.println(factorial(n)/(factorial(k)*(factorial(n-k))));

    }

    //팩토리얼 구하는 공식
    static int factorial(int num)
    {
        int result = 1; //0과 1 팩토리얼은 1이기 때문에 1부터 시작

        for(int i = 2; i <= num; i++)
        {
            result = result * i;
        }
        return result;
    }
}