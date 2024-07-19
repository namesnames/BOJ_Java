import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[] dr = new int[]{0,-1,0,1};
    static int[] dc = new int[]{1,0,-1,0};
    static int[][] matrix;
    static int cnt;

    static void bfs(int x, int y){
        cnt = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x,y});
        matrix[x][y] = 1;

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            cnt++;
            int r = cur[0];
            int c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && nr < M && 0 <= nc && nc < N && matrix[nr][nc] == 0) {
                    matrix[nr][nc] = 1;
                    dq.add(new int[]{nr,nc});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        matrix = new int[M][N];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int y=a; y<c; y++){
                for(int x=b; x<d; x++){
                    matrix[x][y] = 1;
                }
            }
        }

        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int r=0; r<M; r++){
            for(int c=0; c<N; c++){
                if(matrix[r][c] == 0){
                    bfs(r,c);
                    answer++;
                    list.add(cnt);
                }
            }
        }
        System.out.println(answer);
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

    }
}
