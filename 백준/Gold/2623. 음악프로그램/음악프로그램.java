import java.io.*;
import java.util.*;

// 불가능할 때 0을 출력하라고 했는데
// 내가 줄바꿈 고려해서 sb.length() == N * 2이면 sb출력, 아니면 0 출력하도록 했는데 그럼 틀리네
// 그냥 큐에 add할 때마다 count++ 해서 count == N이면 sb출력이 정확한듯
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
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0; j<n-1; j++){
                matrix[arr[j]].add(arr[j+1]);
                inDegree[arr[j+1]]++;
            }
        }

        Queue<Integer> dq = new ArrayDeque<>();
        for(int i=1; i<N+1; i++){
            if(inDegree[i] == 0) dq.add(i);
        }

        int count = 0;
        while(!dq.isEmpty()){
            int node = dq.poll();
            sb.append(node).append("\n");
            count++;
            for(int m : matrix[node]){
                inDegree[m]--;
                if(inDegree[m] == 0) dq.add(m);
            }
        }

        if(count == N){
            System.out.println(sb);
        }
        else{
            System.out.println(0);
        }


    }
}
