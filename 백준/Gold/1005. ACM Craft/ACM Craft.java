import java.io.*;
import java.util.*;

// 위상정렬(진입차선) + 메모이제이션(dp)
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //건물 갯수
            int K = Integer.parseInt(st.nextToken());
            int[] inDegree = new int[N+1];

            // 2차원 간선 리스트 
            List<Integer>[] matrix = new ArrayList[N+1];
            for(int i=1; i<N+1; i++){
                matrix[i] = new ArrayList<>();
            }

            int[] hour = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++){
                hour[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                matrix[a].add(b);
                inDegree[b]++;
            }

            int want = Integer.parseInt(br.readLine());
            int[] dp = new int[N+1];  // i번째 건물을 짓는데 걸리는 최대 시간

            Deque<Integer> dq = new ArrayDeque<>();
            // 진입차선이 0인 녀석들을 큐에 넣는다 (그것들이 시작점임)
            for(int i=1; i<N+1; i++){
                if(inDegree[i] == 0){
                    dq.add(i);
                    dp[i] = hour[i];
                }
            }

            while(!dq.isEmpty()){
                int node = dq.poll(); //현재 큐에 있는 거 하나 꺼내도
                for(int next : matrix[node]){  //여기서 갈 수 있는 녀석들 봄
                    dp[next] = Math.max(dp[next], dp[node] + hour[next]); //내가 갈 수 있는 건물을 짓는데 걸리는 시간을 dp에 기록
                    inDegree[next]--; //next의 진입차선 줄여주고
                    if(inDegree[next] == 0) dq.add(next); //진입차선 0이면 큐에 넣고
                }
            }
            System.out.println(dp[want]);
        }
    }
}