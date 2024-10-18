import java.io.*;
import java.util.*;

// 1부터 100까지 dfs돌면서 싸이클 있는지 모두 확인
public class Main{
    static int[] arr;
    static boolean[] V, visited;
    static int start;
    static List<Integer> list;

    static void dfs(int n){
        list.add(n);
        if(start == arr[n]){
            for(int i : list){
                V[i] = true;
            }
            return;
        }

        if(!visited[arr[n]]) {
            visited[arr[n]] = true;
            dfs(arr[n]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        V = new boolean[N+1];
        visited = new boolean[N+1];
        list = new ArrayList<>();
        for(int i=1; i<N+1; i++){
            if(!V[i]){
                list.clear();
                Arrays.fill(visited, false);
                visited[i] = true;
                start = i;
                dfs(i);
            }
        }
        int cnt = 0;
        for(int i=1; i<N+1; i++){
            if(V[i]) cnt++;
        }
        System.out.println(cnt);
        for(int i=1; i<N+1; i++){
            if(V[i]) System.out.println(i);
        }

    }
}

