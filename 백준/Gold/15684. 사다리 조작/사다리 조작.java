import java.io.*;
import java.util.*;

public class Main{
    static int N,H;
    static int[][] matrix;
    static int[] dc = new int[]{-1,0};
    static boolean[] arr;
    static int answer;
    static boolean check(){
//        for(int i=0; i<N*H; i++){
//            if(arr[i]) System.out.print(i + " ");
//        }
        for(int c=0; c<N; c++){
            int nowC = c;
            for(int r=0; r<H; r++){
                for(int d=0; d<2; d++) {
                    int nc = nowC + dc[d];
                    if (0 <= nc && nc < N) {
                        if (arr[r * N + nc]) {
                            if (d == 0) {
                                nowC -= 1;
                                break;
                            }
                            else {
                                if(nowC + 1 >= N) continue;
                                else nowC += 1;
                                break;
                            }
                        }
                    }
                }
                //System.out.println(r*N + nowC);
            }
            if(nowC != c) return false;
        }
        return true;
    }
    // 0 2 7 11 13 16 20 23

    // 0  1  2  3  4
    // 5  6  7  8  9
    // 10 11 12 13 14
    // 15 16 17 18 19
    // 20 21 22 23 24
    //// 1-> 6 -> 12 -> 16 -> 20
    static void dfs(int start, int depth){
        if(check()){
            if(depth < answer) answer = depth;
            return;
        }
        if(depth == 3) return;

        int next = 0;
        for(int i=start; i<H*N; i++){
            if(!arr[i]){
                if(i/N == (i+1)/N) next = i + 2; // 같은 줄이면 바로 다음거는 x
                else next = i + 1; // 다른 줄이면 가능
                arr[i] = true;
                dfs(next, depth+1);
                arr[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new boolean[H * N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // [r-1][c-1]에 체크
            arr[(r-1)*N + c-1] = true;
        }
        matrix = new int[H][N];

        answer = 4;
        dfs(0,0);
        if(answer == 4) System.out.println(-1);
        else System.out.println(answer);
    }
}