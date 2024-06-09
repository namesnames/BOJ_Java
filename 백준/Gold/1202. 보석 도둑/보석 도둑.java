import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        int[] bag = new int[K];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new int[]{m,v});
        }

        for(int i=0; i<K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Collections.sort(list, (a,b)-> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;
        int idx = 0;
        for(int b : bag){
            while(idx < N && list.get(idx)[0] <= b){
                pq.add(list.get(idx)[1]);
                idx++;
            }

            if(!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}

