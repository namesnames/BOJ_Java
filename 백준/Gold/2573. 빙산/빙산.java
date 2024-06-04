import java.io.*;
import java.util.*;

public class Main {
// bfs는 넣을 때 visited체크, 뺄 때 하면 메모리초과
    static int N;
    static int M;
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0};
    static int[][] matrix;
    static int[][] matrix2;

    public static boolean check(int x, int y) {
        //System.out.println("여기 x"+x+"y"+y);
        ArrayDeque<int[]> dq2 = new ArrayDeque<>();
        dq2.add(new int[]{x, y});
        int[][] visited = new int[N][M];
        while (!dq2.isEmpty()) {
            int[] temp = dq2.poll();
            int r = temp[0];
            int c = temp[1];
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && visited[nr][nc] == 0) {
                    if (matrix[nr][nc] > 0) {
                        //System.out.println("여기 r"+nr+ "c"+nc+"값"+matrix[nr][nc]);
                        cnt++;
                        visited[nr][nc] = 1;
                        dq2.add(new int[]{nr, nc});
                    }
                }
            }
        }
        for (int p = 0; p < N; p++) {
            for (int q = 0; q < M; q++) {
                //System.out.print(visited[p][q]+" ");
                if (matrix[p][q] > 0 && visited[p][q] == 0) return false;
            }
            //System.out.println();
        }
        return true;

    }
    public static void melt(){
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                matrix[r][c] -= matrix2[r][c];
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        matrix2 = new int[N][M];
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                int num = Integer.parseInt(st.nextToken());
                if(num > 0){
                    dq.add(new int[]{r,c,0});
                }
                matrix[r][c] = num;
            }
        }

        int trigger = 0;
        int[][] visited = new int[N][M];
        while(!dq.isEmpty()){
            int[] temp = dq.poll();
            int r = temp[0];
            int c = temp[1];
            int y = temp[2];

            if(y > trigger){
                trigger = y;
                melt();
                int thisr = 0;
                int thisc = 0;
                for(int t=0; t<N; t++) {
                    for (int u = 0; u < M; u++) {
                        if(matrix[t][u] > 0){
                            thisr = t;
                            thisc = u;
                        }
                    }
                }
                if(check(thisr,thisc) == false){
                    System.out.println(y);
                    return;
                }
                matrix2 = new int[N][M];
                visited = new int[N][M];
            }
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(0<=nr && nr<N && 0<=nc && nc<M){
                    if(matrix[nr][nc] <= 0) matrix2[r][c]++;
                    if(matrix[nr][nc] > 0 && visited[nr][nc] == 0) {
                        visited[nr][nc] = 1;
                        dq.add(new int[]{nr,nc,y+1});
                    }
                }
            }
        }

        System.out.println(0);
    }
}

