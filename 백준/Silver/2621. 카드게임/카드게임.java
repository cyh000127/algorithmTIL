import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] card=new int[5];
        char[] color=new char[5];
        for(int i=0; i<5; i++){
            st=new StringTokenizer(br.readLine());
            color[i]=st.nextToken().charAt(0);
            card[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);
        boolean color_same=true;
        char col=color[0];
        for(int i=1; i<5; i++){
            if(col!=color[i]){
                color_same=false;
            }
        }
        int total=0;
        if(color_same && card[0]+1==card[1] && card[1]+1==card[2] && card[2]+1==card[3] && card[3]+1==card[4]){
            total=900+card[4];
        }
        else if(card[0]==card[3] || card[1]==card[4]){
            total=800+card[3];
        }
        else if((card[0]==card[2] && card[3]==card[4]) || (card[0]==card[1] && card[2]==card[4])){
            total=card[2]*10+700;
            total+= card[2]==card[4] ? card[0] : card[4];
        }
        else if(color_same){
            total=600+card[4];
        }
        else if(card[0]+1==card[1] && card[1]+1==card[2] && card[2]+1==card[3] && card[3]+1==card[4]){
            total=500+card[4];
        }
        else if(card[0]==card[2] || card[2]==card[4]){
            total=400+card[2];
        }
        else {
            int same = 0;
            int temp = 0;
            for (int i = 0; i < 4; i++) {
                if (card[i] == card[i + 1]) {
                    same++;
                    temp = card[i];
                }
            }
            if (same == 2) {
                total = 300 + temp * 10 + card[1];
            } else if (same == 1) {
                total = 200 + temp;
            } else {
                total = 100 + card[4];
            }
        }
        bw.write(total+"");
        bw.flush();
    }
}