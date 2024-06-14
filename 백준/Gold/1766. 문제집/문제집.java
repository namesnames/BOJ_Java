import java.io.*;
import java.util.*;
// 위상정렬
// 진입차선 배열 inDegree, 간선리스트

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
