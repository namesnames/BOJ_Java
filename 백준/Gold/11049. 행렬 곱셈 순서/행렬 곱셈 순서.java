import java.io.*;
import java.util.*;

// https://www.youtube.com/watch?v=5MXOUix_Ud4&t=1659s
// 이 강의가 도움이 됨

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] m = new int[N][N];

        if(N == 1){ // N이 1일때 분기처리
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(0);
            return;
        }

        // N이 2이상일 때
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            m[i][0] = a;
            m[i][1] = b;
        }


        for(int r=0; r<N-1; r++){ // r이랑c가 1차이 나는 것먼저
            dp[r][r+1] = m[r][0] * m[r][1] * m[r+1][1];
        }

        // 행렬이 
        // 0 2   1 3   2 4
        // 0 3   1 4
        // 0 4 
        // 이런식으로 진행돼야해서
        for(int d=2; d<N; d++){ // d는 간격
            for(int r=0; r+d<N; r++){
                int min = Integer.MAX_VALUE;
                for(int k=r; k<r+d; k++){ // 이 부분은 위에 유튜브 강의 링크로 이해
                    min = Math.min(min, dp[r][k]+ dp[k+1][r+d] + m[r][0]*m[k][1]*m[r+d][1]);
                }
                dp[r][r+d] = min;
            }
        }

        System.out.println(dp[0][N-1]);
    }
}

