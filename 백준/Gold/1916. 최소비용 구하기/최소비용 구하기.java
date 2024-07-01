import java.io.*;
import java.util.*;


public class Main {

    static void dijkstra(int start, int[] dist, List<int[]>[] list){
        Queue<int[]> pq = new PriorityQueue<>((a,b)->{return a[1]-b[1];});
        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(dist[cur[0]] <= cur[1]) continue;

            dist[cur[0]] = cur[1];
            for(int[] next : list[cur[0]]){
                pq.add(new int[]{next[0], next[1] + cur[1]});
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<int[]>[] list = new ArrayList[N+1];
        for(int r=1; r<N+1; r++){
            list[r] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,v});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(start, dist, list);


        System.out.println(dist[end]);
    }
}

