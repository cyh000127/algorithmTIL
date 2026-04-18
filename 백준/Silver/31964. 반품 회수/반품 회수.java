import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       // 1 부터 N 까지 번호
       // N개의 집이 있음

       // 반품되는 물건을 회수하려고 함

       // 0에서 출발
       // i번 집은 Ti에 반품할 물건을 내놓음
       // 트럭은 움직이지 않을 수 있음 

       // 물건 회수에 걸리는 시간은 0 
       //  Ti 시간에 물건을 내놓는데 물건 회수하러 왔다 가려면 어떻게 해야함

       int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] home = new int[n];
        int[] time = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i =0 ; i<n; i++){
            home[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st2.nextToken());
        }

        int ans = home[n-1]; // 끝까지 간 후 회수해도 됨

        for(int i =n-1 ; i>=0 ;i--){
            if(i!=n-1){
            ans += home[i+1] - home[i];
            }
            if(ans < time[i]){
                ans += time[i] -ans;
            } 
        }

            ans += home[0];

        System.out.println(ans);
        
    }
}