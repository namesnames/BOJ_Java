import java.io.*;
import java.util.*;
// 위상정렬
// 진입차선 배열 inDegree, 간선리스트, PQ
// 너무 어렵게 생각했다, 간선리스트를 PQ로 + dfs도 섞어서 했는데 자꾸 틀렸음

// 그냥 Original 위상정렬인데 마지막에 deque 대신에 PQ쓰면 됐음
// 4 2
// 4 2
// 3 1 과 같은 상황이면 처음에 3이랑 4가 진입차수가 없어서 큐에 바로 들어갈 것임
// 3먼저 빠지는데 빠지는 동시에 연결된 1의 진입차수도 0이 돼서 큐에 들어감
// 이때 1이 4보다 먼저 시행돼야 하니까 일반 큐가 아니라 PQ를 쓰면 간단히 해결되는 것

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] matrix = new ArrayList[N+1];
        for(int r=1; r<N+1; r++){
            matrix[r] = new ArrayList<>();
        }

        int[] inDegree = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a].add(b);
            inDegree[b]++;
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<N+1; i++){
            if(inDegree[i] == 0) pq.add(i);
        }

        while(!pq.isEmpty()){
            int node = pq.poll();
            sb.append(node).append(" ");
            for(int m : matrix[node]){
                inDegree[m]--;
                if(inDegree[m] == 0) pq.add(m);
            }
        }

        System.out.println(sb);
    }
}
