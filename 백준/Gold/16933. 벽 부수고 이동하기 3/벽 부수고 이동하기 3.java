import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0};
    static int N,M;
    static int[][] matrix;
    static int[][][] V;

    static void bfs(int x, int y, int wall){
        Queue<int[]> dq = new PriorityQueue<>((a,b)->Integer.compare(a[3],b[3]));
        V[x][y][wall] = 1;
        dq.add(new int[]{x,y,wall,V[x][y][wall]});


        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int r = cur[0];
            int c = cur[1];
            int K = cur[2];

            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(0<=nr && nr<N && 0<=nc && nc<M && matrix[nr][nc] == 0 && V[nr][nc][K] == 0){
                    V[nr][nc][K] = V[r][c][K] + 1;
                    dq.add(new int[]{nr,nc,K,V[nr][nc][K]});
                }
            }
            if(K > 0){
                for(int d=0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(0<=nr && nr<N && 0<=nc && nc<M && matrix[nr][nc] == 1 && V[nr][nc][K-1] == 0){
                        if(V[r][c][K] % 2 == 1){
                            V[nr][nc][K-1] = V[r][c][K] + 1;
                            dq.add(new int[]{nr,nc,K-1,V[nr][nc][K-1]});
                        }
                        else {
                            V[nr][nc][K-1] = V[r][c][K] + 2;
                            dq.add(new int[]{nr,nc,K-1,V[nr][nc][K-1]});
                        }
                    }
                }
            }


        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        V = new int[N][M][K+1];

        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<M; c++){
                matrix[r][c] = str.charAt(c) - '0';
            }
        }

        bfs(0,0,K);
//
//        for(int r=0; r<N; r++){
//            for(int c=0; c<M; c++){
//                System.out.print(V[r][c][9] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//        System.out.println();
//        for(int r=0; r<N; r++){
//            for(int c=0; c<M; c++){
//                System.out.print(V[r][c][9] + " ");
//            }
//            System.out.println();
//        }

        boolean check = false;
        for(int k=0; k<K+1; k++) {
            if (V[N - 1][M - 1][k] != 0) check = true;
        }

        int min = Integer.MAX_VALUE;
        if(check){
            for(int k=0; k<K+1; k++){
                int value = V[N-1][M-1][k];
                if(value != 0) min = Math.min(min, value);
            }
            System.out.println(min);
        }
        else System.out.println(-1);

    }
}
