import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0};
    static int R,C;
    static Character[][] matrix;
    static Set<Character> set = new HashSet<>();
    static int max = Integer.MIN_VALUE;

    static void dfs(int r, int c, int depth){

        if(depth == R*C){
            max = R*C;
            return;
        }

        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(0<=nr && nr<R && 0<=nc && nc<C){
                if(set.contains(matrix[nr][nc])){ // 그 쪽으로는 가지도 않음
                    max = Math.max(max, depth);
                }
                else{
                    set.add(matrix[nr][nc]);
                    dfs(nr,nc,depth+1);
                    set.remove(matrix[nr][nc]);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        matrix = new Character[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                matrix[r][c] = str.charAt(c);
            }
        }

        set.add(matrix[0][0]);
        dfs(0,0,1);
        System.out.println(max);
    }
}
