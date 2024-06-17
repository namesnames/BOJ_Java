import java.io.*;
import java.util.*;

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
        D[N] = 0;
        cnt[N] = 1;

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            int[] nextPositions = {cur * 2, cur - 1, cur + 1};
            for (int next : nextPositions) {
                if (next >= 0 && next < 100001) {
                    if (!V[next]) {
                        dq.add(next);
                        V[next] = true;
                        D[next] = D[cur] + 1;
                        cnt[next] = cnt[cur];
                    } else if (D[next] == D[cur] + 1) {
                        cnt[next] += cnt[cur];
                    }
                }
            }
        }

        System.out.println(D[K]);
        System.out.println(cnt[K]);
    }
}
