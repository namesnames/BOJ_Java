import java.io.*;
import java.util.*;

// cnt 배열은 start지점부터 각 지점까지 최소시간으로 도달할 수 있는 모든 경우의 수를 저장해놓음
// 이렇게 안해도 되지만 해보고 싶어서 GPT도움 받아봄

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] V = new boolean[100001];
        int[] D = new int[100001];
        int[] cnt = new int[100001];

        Queue<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        V[N] = true;
        cnt[N] = 1;

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            int[] nextArr = {cur * 2, cur - 1, cur + 1};
            for(int next : nextArr){
                if(0<= next && next < 100001) {
                    if (V[next] == false) {
                        D[next] = D[cur] + 1;
                        V[next] = true;
                        dq.add(next);
                        cnt[next] = cnt[cur];
                    } else if (D[next] == D[cur] + 1){
                        cnt[next] += cnt[cur];
                    }
                }
            }

        }
        System.out.println(D[K]);
        System.out.println(cnt[K]);
    }
}
