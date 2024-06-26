import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = new int[]{0,0,0,0,0,1,2,3,0,0,1,1,0,0,-1,-2,0,-1,-1,-1,0,0,1,2,0,1,1,1,0,0,-1,-2,0,-1,-1,-1,0,0,1,2,0,1,1,1,0,1,1,2,0,1,1,2,0,0,-1,-1,0,0,1,1,0,0,0,1,0,-1,1,0,0,0,0,-1,0,-1,1,0};
    static int[] dc = new int[]{0,1,2,3,0,0,0,0,0,1,1,0,0,-1,-1,-1,0,0,1,2,0,1,1,1,0,0,-1,-2,0,1,1,1,0,0,-1,-2,0,-1,-1,-1,0,0,1,2,0,0,1,1,0,0,-1,-1,0,1,1,2,0,1,1,2,0,-1,1,0,0,0,0,1,0,-1,1,0,0,0,0,-1};
    static int len = dr.length;
    static int N,M;
    static int max = Integer.MIN_VALUE;
    static int [][] matrix;

    static void check(int r, int c){
        int cnt = 0;
        int trigger = 0;
        int result = 0;
        for(int d=0; d<len; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(0<=nr && nr<N && 0<=nc && nc<M){
                cnt++;
                result += matrix[nr][nc];
            }
            if(cnt == 4){
                max  = Math.max(max,result);
            }
            trigger++;
            if(trigger == 4){
                trigger = 0;
                result = 0;
                cnt = 0;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));




        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                check(r,c);
            }
        }
        System.out.println(max);
    }
}
