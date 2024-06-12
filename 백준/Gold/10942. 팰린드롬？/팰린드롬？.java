import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[][] dp = new int[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 길이 1
        for(int r=1; r<N+1; r++){
            for(int c=1; c<N+1; c++){
                if(r == c) dp[r][c] = 1;
            }
        }

        // 길이2
        for(int i=1; i<N+1; i++){
            if(arr[i-1] == arr[i]) dp[i-1][i] = 1;
        }

        for(int d=2; d<N; d++){ // 간격 N=7 이라면 간격을 2부터 6까지 늘려감
            for(int i=1; i+d<=N; i++){
                if(arr[i] == arr[i+d] && dp[i+1][i+d-1] == 1) dp[i][i+d] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a][b]).append("\n");
        }
        System.out.println(sb);
    }
}

