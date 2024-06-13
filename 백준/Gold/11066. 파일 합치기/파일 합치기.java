
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N][N];
            int[] sum = new int[N + 1]; // Prefix sum 배열 생성

            for (int i = 1; i <= N; i++) {
                sum[i] = sum[i - 1] + arr[i - 1];
            }

            for (int d = 1; d < N; d++) { // 간격 1부터 N-1까지
                for (int i = 0; i + d < N; i++) {
                    int j = i + d;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
                    }
                }
            }

            System.out.println(dp[0][N - 1]);
        }
    }
}
