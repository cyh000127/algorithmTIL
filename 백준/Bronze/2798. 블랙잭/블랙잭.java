import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int diff = Integer.MAX_VALUE;
    static int[] arr;
    static int targetnum;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int card = Integer.parseInt(st.nextToken());
        targetnum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[card];
        for (int i = 0; i < card; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr);
        System.out.println(result);
    }

    static int search(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int arrsum = arr[i] + arr[j] + arr[k];
                    if (targetnum < arrsum) {
                        continue;
                    }
                    if (arrsum == targetnum) {
                        return targetnum;
                    } else if (targetnum - arrsum < diff) {
                        diff = targetnum - arrsum;
                        ans = arrsum;
                    }
                }
            }
        }
        return ans;
    }
}