import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] done;
    static boolean[] V;
    static int total;

    static void dfs(int i){
        if(done[i] == true) return;
        if(V[i] == true){
            done[i] = true;
            total++;
        }
        V[i] = true;
        dfs(arr[i]);
        V[i] = false;
        done[i] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            V = new boolean[N+1];
            done = new boolean[N+1];

            total = 0;
            for(int i=1; i<N+1; i++){
                if(done[i] == false) dfs(i);
            }
            System.out.println(N-total);
        }
    }
}

