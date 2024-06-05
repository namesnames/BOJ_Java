import java.io.*;
import java.util.*;

// PQ쓴 풀이

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<M; i++){
            long a = pq.poll();
            long b = pq.poll();
            long num = a+b;
            pq.add(num);
            pq.add(num);
        }

        long answer = 0;
        for(long a : pq){
            answer += a;
        }
        System.out.println(answer);
    }
}
