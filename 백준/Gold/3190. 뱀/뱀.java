import java.io.*;
import java.util.*;


public class Main {
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a-1][b-1] = 2; // 사과
        }

        int L = Integer.parseInt(br.readLine());
        Deque<Integer> Ndq = new ArrayDeque<>();
        Deque<Character> Cdq = new ArrayDeque<>();
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            char c = str.charAt(0);
            Ndq.add(n);
            Cdq.add(c);
        }

        int[][] V = new int[N][N];
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0,0});
        V[0][0] = 1;
        int time = 0;
        int d = 0;
        while(true){

            if(!Ndq.isEmpty() && time == Ndq.getFirst()){
                Ndq.poll();
                char cha = Cdq.poll();
                if(cha == 'D') d = (d + 1) % 4;
                else d = (d + 3) % 4; // 이 부분 처음에 d = (d - 1) % 4로 하다가 -> Math.abs(d-1)%4로함 // 무조건 더하는 식으로 하자
            }

            time++;
            int[] head = snake.getLast();
            int nr = head[0] + dr[d];
            int nc = head[1] + dc[d];
//            System.out.println("r " + nr + " c "+ nc);
            if(nr < 0 || nr >= N || nc < 0 || nc >=N){
                System.out.println(time);
                return;
            }
            if(V[nr][nc] == 1){
                System.out.println(time);
                return;
            }
            if(matrix[nr][nc] == 2){
                matrix[nr][nc] = 0;
                snake.add(new int[]{nr,nc});
                V[nr][nc] = 1;
            }else {
                int[] tail = snake.poll();
                V[tail[0]][tail[1]] = 0;
                snake.add(new int[]{nr, nc});
                V[nr][nc] = 1;
            }

        }

    }
}

