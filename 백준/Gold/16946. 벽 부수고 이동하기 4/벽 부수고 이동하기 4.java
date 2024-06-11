import java.io.*;
import java.util.*;

public class Main {
// 0 그룹화 -> O(백만)
// 벽마다 갈 수 있는 곳 체크 -> 체스판처럼 1010 돼 있을 때, 가장 많이 연산해야하므로 O(50만)추정

    static int N,M;
    static int[] dr = new int[]{0,-1,0,1};
    static int[] dc = new int[]{1,0,-1,0};
    static int[][] matrix, Group;
    static int[] V = new int[1000000]; // N번 그룹이 몇 개 있는지 기록할 V배열

    static int bfs(int x, int y, int num){
        int cnt = 1;
        Group[x][y] = num;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x,y});
        while(!dq.isEmpty()){
            int[] node = dq.poll();
            int r = node[0];
            int c = node[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(0<=nr && nr<N && 0<=nc && nc<M && Group[nr][nc] == 0 && matrix[nr][nc] == 0){
                    Group[nr][nc] = num;
                    dq.add(new int[]{nr,nc});
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        Group = new int[N][M];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                matrix[r][c] = str.charAt(c) - '0';
            }
        }

        int cnt = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (matrix[r][c] == 0 && Group[r][c] == 0) {
                    V[cnt] = bfs(r, c, cnt);
                    cnt++;
                }
            }
        }

        // 여기까지 Group 세팅

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(matrix[r][c] == 1){ //벽일 때 사방탐색해서 해당 0's 그룹 갯수를 더해줌
                    Set<Integer> set = new HashSet<>();
                    for(int d=0; d<4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(0<=nr && nr<N && 0<=nc && nc<M){
                            int idx = Group[nr][nc];
                            if(!set.contains(idx)){ // 오른쪽에도 2그룹이 있을 수 있고, 위에도 2그룹이 있을 수 있어서 set로 구분해준다
                                set.add(idx);
                                matrix[r][c] += V[idx];
                            }
                        }
                    }
                }
                matrix[r][c] = matrix[r][c] % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sb.append(matrix[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

