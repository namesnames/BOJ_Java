import java.io.*;
import java.util.*;

// https://cocoon1787.tistory.com/319
// 더 자세한 주석은 아래에

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        // dp[r][c]은 r번째까지 고려했을 때, 비용 c를 소모했을 때의 최대 메모리
        // 나(r번째)를 고를 수 있으면 고르고, 나를 골랐을 때의 남은 돈으로, 나를 고르기 전의 상황에서 가장 큰 값을 가져오는 것
        // 그것이 dp[r-1][c-cpst[r]]임

        int[][] dp = new int[N+1][10001];
        for(int r=1; r<N+1; r++){
            for(int c=0; c<10001; c++){ // 비용을 0원 썼을 때부터 계산해야함 //비용0쓰고도 충족할 수도 있으니
                if(c - cost[r] >= 0){
                    dp[r][c] = Math.max(dp[r][c], dp[r-1][c-cost[r]] + arr[r]); // 나를 넣을 거임 + 그럼 나를 고려하기 전까지의 결과를 가져와서 더해
                }
                dp[r][c] = Math.max(dp[r][c],dp[r-1][c]); // 맨 마지막 행에서 답을 뽑을 것이기 때문에
            }
        }

        for(int c=0; c<10001; c++){
            if(dp[N][c] >= M) {
                System.out.println(c);
                return;
            }
        }
    }
}
