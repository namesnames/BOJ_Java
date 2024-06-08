import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] S;
    static int[] W;
    static int max = 0;

    // 나의 무게로 상대방의 내구도를 감소시킨다
    static void hit(int depth){
        if(depth == N){
            int cnt = 0;
            for(int i = 0; i < N; i++){
                if(S[i] <= 0) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }

        for(int i = 0; i < N; i++){
            if(i != depth)
            if(S[depth] > 0 && S[i] > 0) {
                S[depth] -= W[i];
                S[i] -= W[depth];
                hit(depth+1);
                S[depth] += W[i];
                S[i] += W[depth];
            }
            else hit(depth+1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N];
        W = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            S[i] = s;
            W[i] = w;
        }

        hit(0);

        System.out.println(max);
    }
}
