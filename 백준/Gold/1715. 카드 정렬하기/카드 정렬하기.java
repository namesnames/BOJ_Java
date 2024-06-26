import java.io.*;
import java.util.*;

// 그냥 제일 작은 두 녀석 더해가면됨 -> PQ
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>();
        for(int r=0; r<N; r++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        if(N == 1){
            System.out.println(0);
            return;
        }

        int answer = 0;
        while(pq.size() != 1){
            int a = pq.poll();
            int b = pq.poll();
            answer += (a+b);
            pq.add(a+b);
        }

        System.out.println(answer);

    }
}
