import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] matrix;
    static int[][] dp;
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0};

    static int dfs(int r, int c){

        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 1;
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(0<=nr && nr<N && 0<=nc && nc<N){
                if(matrix[r][c] < matrix[nr][nc]){
                    dp[r][c] = Math.max(dp[r][c], dfs(nr,nc) + 1);
                }
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        dp = new int[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                dp[r][c] = -1;
            }
        }

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                max = Math.max(max, dfs(r,c));
            }
        }
        System.out.println(max);
    }
}

