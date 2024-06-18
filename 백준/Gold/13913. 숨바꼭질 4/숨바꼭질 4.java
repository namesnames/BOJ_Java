import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] V = new int[100001];

        if(N == 0 && K == 0){
            System.out.println(0);
            System.out.println(0);
            return;
        }

        Queue<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        V[N] = 1;

        while(!dq.isEmpty()){
            int cur = dq.poll();
            int[] nextArr = {cur*2, cur-1, cur+1};
            for(int next : nextArr){
                if(0<=next && next<100001 && V[next] == 0){
                        dq.add(next);
                        V[next] = V[cur] + 1;
                }
            }
        }
        System.out.println(V[K]-1);

        // 역추적
        Queue<Integer> rdq = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        rdq.add(K);
        answer.add(K);
        int target = V[K]-1;
        // 역추적 과정도 방문체크
        boolean[] RV = new boolean[100001];
        RV[K] = true;


        while(!rdq.isEmpty()){
            int cur = rdq.poll();
            if(target == 0) break;
            if(V[cur] == target){
                answer.add(cur);
                target--;
            }

            int[] nextArr = {cur/2, cur+1, cur-1};
            int[] nextBrr = {cur+1, cur-1};
            if(cur % 2 == 0){
                for(int next : nextArr){
                    if(0<=next && next<100001 && RV[next] == false) {
                        rdq.add(next);
                        RV[next] = true;
                    }
                }
            }
            else{
                for(int next : nextBrr){
                    if(0<=next && next<100001 && RV[next] == false){
                        rdq.add(next);
                        RV[next] = true;
                    }
                }
            }
        }
        for(int i=answer.size()-1; i>-1; i--){
            System.out.print(answer.get(i) + " ");
        }

    }
}
