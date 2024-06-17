import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] check = new boolean[100001];
        int[] V = new int[100001];

        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        V[start] = 0;

        while(!dq.isEmpty()){
            int i = dq.poll();
            if(i == dest) break;

            // 순서가 중요
            // i*2, i-1, i+1 순으로 해야 정답
            int ni = i*2;
            if(0<=ni && ni<=100000 && check[ni] == false){
                V[ni] = V[i];
                check[ni] = true;
                dq.addFirst(ni);
            }

            ni = i-1;
            if(0<=ni && ni<=100000 && check[ni] == false) {
                V[ni] = V[i] + 1;
                check[ni] = true;
                dq.add(ni);
            }

            ni = i+1;
            if(0<=ni && ni<=100000 && check[ni] == false) {
                V[ni] = V[i] + 1;
                check[ni] = true;
                dq.add(ni);
            }
        }
        System.out.println(V[dest]);
    }
}
