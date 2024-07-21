import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            sum += a;
        }

        if(sum % 4 != 0){
            System.out.println(0);
            return;
        }

        int[] prefixSum = new int[N];
        prefixSum[0] = arr[0];
        for(int i=1; i<N; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int[][] dp = new int[3][N];
        if(prefixSum[0] == sum / 4) {
            dp[0][0] = 1;
        }

        for(int i=1; i<N; i++){
            if(prefixSum[i] == (sum/4) * 1) dp[0][i] = dp[0][i-1] + 1;
            else dp[0][i] = dp[0][i-1];
        }

        dp[1][0] = 0;
        for(int i=1; i<N; i++){
            if(prefixSum[i] == (sum/4) * 2) dp[1][i] = dp[1][i-1] + dp[0][i];
            else dp[1][i] = dp[1][i-1];
        }

        dp[2][0] = 0;
        for(int i=1; i<N; i++){
            if(prefixSum[i] == (sum/4) * 3) dp[2][i] = dp[2][i-1] + dp[1][i];
            else dp[2][i] = dp[2][i-1];
        }

        System.out.println(dp[2][N-1]);
    }
}
