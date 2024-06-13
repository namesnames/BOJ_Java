import java.io.*;
import java.util.*;

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
//
//        for(int d=2; d<N; d++){
//            for(int r=0; r+d<N; r++){
//                for(int c=r+d; c<N; c++){
//                    int min = Integer.MAX_VALUE;
//                    for(int k=r; k<c; k++){
//                        System.out.println(" r "+r + " k " + k + " | k+1 "+ (k+1) +" c " + c);
//                        System.out.println(" r "+ r + " c " + c);
//                        min = Math.min(min, dp[r][k] + dp[k+1][c] + m[r][0]*m[k][1]*m[c][1]);
//                    }
//                    dp[r][c] = min;
//                }
//            }
//        }

        for(int d=2; d<N; d++){
            for(int r=0; r+d<N; r++){
                int min = Integer.MAX_VALUE;
                for(int k=r; k<r+d; k++){
                    min = Math.min(min, dp[r][k]+ dp[k+1][r+d] + m[r][0]*m[k][1]*m[r+d][1]);
                }
                dp[r][r+d] = min;
            }
        }

//        for(int r=0; r<N; r++){
//            for(int c=0; c<N; c++){
//                System.out.print(dp[r][c] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[0][N-1]);
    }
}

