import java.io.*;
import java.util.*;
// 어렵다 완벽히 이해하지 못했다
// https://developerbee.tistory.com/97 참고

// 백준 11049번 - 행렬 곱셈 순서 와 비슷한 문제
// 각 값들의 2배를 해주고 더한 것중에 제일 작은거
// dp[i][j]는 인덱스 i부터 j까지 더한 것중 가장 최적의 값(최소)
// dp[0][3]을 알려면 dp[0][0]+dp[1][3], dp[0][1]+dp[1][3], dp[0][2]+dp[2][3] 중에서 작은 것을 골라야하는 원리
// 점화식 -> dp[i][j] = dp[i][k] + dp[k+1][j]

// 근데 [0][3]을 알려면 [0][2],[1][3]을 먼저 알아야하고 또 [0][1],[2][3] 을 알아야함
// 보면 간격이 더 작은 녀석들 부터 알아야한다는 것을 알 수 있음


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
