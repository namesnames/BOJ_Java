import java.io.*;
import java.util.*;

public class Main {
    // 그리디
    // 무조건 양끝에 있어야함
    // 그럼 경우의 수가 3가지가 나옴
    // 벌벌통
    // 통벌벌
    // 벌통벌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = arr[0];
        for(int i=1; i<N; i++){
            dp[i] = arr[i] + dp[i-1];
        }

        long max = 0;
        // 벌벌통
        long first = dp[N-1] - dp[0];
        for(int i=1; i<N-1; i++){
            long temp = first - arr[i];
            long second = dp[N-1] - dp[i];
            max = Math.max(max, temp + second);
        }
        // 통벌벌
        first = dp[N-2];
        for(int i=1; i<N-1; i++){
            long temp = first - arr[i];
            long second = dp[i-1];
            max = Math.max(max, temp + second);
        }
        // 벌통벌
        for(int i=1; i<N-1; i++){
            max = Math.max(max, dp[i] - dp[0] + dp[N-2] - dp[i-1]);
        }

        System.out.println(max);
    }
}