import java.io.*;
import java.util.*;
// bfs로 그룹핑
// 각 그룹에 속한 좌표들을 동적배열에 다 저장
// 섬의 모든 좌표들끼리 맨해튼 distance계산해서 최소값 출력

public class Main {
    static int N;
    static int[] dr = {0,-1,0,1};
    static int[] dc = {1,0,-1,0};
    static int[][] matrix, V;
    static List<List<int[]>> list = new ArrayList<>();

    static void bfs(int x, int y){
        Queue<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x,y});
        List<int[]> li = new ArrayList<>();
        li.add(new int[]{x,y});

        while(!dq.isEmpty()){
            int[] node = dq.poll();
            int r = node[0];
            int c = node[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(0<=nr && nr<N && 0<=nc && nc<N && matrix[nr][nc] == 1 && V[nr][nc] == 0){
                    dq.add(new int[]{nr,nc});
                    li.add(new int[]{nr,nc});
                    V[nr][nc] = 1;
                }
            }
        }
        list.add(li);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        StringTokenizer st;

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        V = new int[N][N];

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(matrix[r][c] == 1 && V[r][c] == 0) {
                    V[r][c] = 1;
                    bfs(r,c);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<list.size()-1; i++){
            for(int j=i+1; j<list.size(); j++){
                for(int[] node : list.get(i)){
                    for(int[] Jnode : list.get(j)){
                        if(Math.abs(node[0]-Jnode[0]) + Math.abs(node[1]-Jnode[1]) < min) {
                            min = Math.abs(node[0]-Jnode[0]) + Math.abs(node[1]-Jnode[1]);
                        }
                    }
                }
            }
        }
        System.out.println(min-1);

    }
}
