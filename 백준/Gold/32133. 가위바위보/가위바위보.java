import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static boolean[] arr;
    static String[] strArr;
    static List<Character> answer;
    static List<Character> real;

    static void dfs(int round, int remaining) {
        // 더 이상 남은 사람이 없으면 종료
        if (remaining == 0) return;

        // 남은 인원이 K명 이하가 되면 결과 저장
        if (remaining <= K) {
            if (real.isEmpty() || answer.size() < real.size()) {
                real.clear();
                real.addAll(answer);
            }
            return;
        }

        // 모든 라운드를 다 사용했다면 종료
        if (round == M) return;

        // R, P, S 각 경우를 고려
        for (char c : new char[] {'R', 'P', 'S'}) {
            List<Integer> list = new ArrayList<>();
            int nextRemaining = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i]) {
                    if ((c == 'R' && strArr[i].charAt(round) != 'P') ||
                            (c == 'P' && strArr[i].charAt(round) != 'S') ||
                            (c == 'S' && strArr[i].charAt(round) != 'R')) {
                        list.add(i); // 피돌이를 이기지 못한 친구들
                    } else {
                        nextRemaining++; // 다음 라운드로 갈 수 있는 친구들 수
                    }
                }
            }
            answer.add(c);
            // 해당 라운드에서 탈락한 친구들을 false 처리
            for (int i : list) arr[i] = false;
            dfs(round + 1, nextRemaining);
            // 복구
            for (int i : list) arr[i] = true;
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N];
        strArr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = true;
            strArr[i] = br.readLine();
        }

        answer = new ArrayList<>();
        real = new ArrayList<>();

        dfs(0, N);

        if (real.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(real.size());
            for (char c : real) {
                System.out.print(c);
            }
        }
    }
}
