import java.io.*;
import java.util.*;

// 굴리는 방향, 상하좌우 마다 주사위가 어떤 형태인지만 기억하면 됨

public class Main{
    static int bottom, x, y, N, M;
    static int[] arr;
    static int[] dr = new int[]{0,0,0,-1,1};
    static int[] dc = new int[]{0,1,-1,0,0};
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();
    static void go(int d){

        int nr = x + dr[d];
        int nc = y + dc[d];
        if(0<=nr && nr<N && 0<=nc && nc<M) {
            int tmp = 0;
            if (d == 1) {
                tmp = arr[5];
                arr[5] = arr[2];
                arr[2] = arr[0];
                arr[0] = arr[1];
                arr[1] = tmp;
            } else if (d == 2) {
                tmp = arr[5];
                arr[5] = arr[1];
                arr[1] = arr[0];
                arr[0] = arr[2];
                arr[2] = tmp;
            } else if (d == 3) {
                tmp = arr[5];
                arr[5] = arr[4];
                arr[4] = arr[0];
                arr[0] = arr[3];
                arr[3] = tmp;
            } else if (d == 4) {
                tmp = arr[5];
                arr[5] = arr[3];
                arr[3] = arr[0];
                arr[0] = arr[4];
                arr[4] = tmp;
            }

            x = nr;
            y = nc;
            if(matrix[nr][nc] == 0) matrix[nr][nc] = arr[0];
            else {
                arr[0] = matrix[nr][nc];
                matrix[nr][nc] = 0; // 문제 잘 읽자..
            }
            sb.append(arr[5]).append("\n");
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[6];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 세팅
        bottom = 0;
        if(matrix[x][y] != 0) arr[bottom] = matrix[x][y];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            go(Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb);
    }
}