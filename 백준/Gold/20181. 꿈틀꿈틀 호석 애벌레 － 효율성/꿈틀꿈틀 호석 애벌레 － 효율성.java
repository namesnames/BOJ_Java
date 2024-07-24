import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N+1];
        int left = 1;
        int right = 1;
        long sum = arr[1];
        while(left <= N){
            dp[right] = Math.max(dp[right], dp[right-1]);
            if(sum < K){
                right++;
                if(right == N+1) break;
                sum += arr[right];
            }
            else{
                dp[right] = Math.max(dp[right], dp[left-1] + sum - K);
                sum -= arr[left];
                left++;
            }
        }
//        for(long i : dp){
//            System.out.print(i + " ");
//        }
        System.out.println(dp[N]);
    }
}