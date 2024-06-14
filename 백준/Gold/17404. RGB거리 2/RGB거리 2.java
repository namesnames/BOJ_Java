import java.io.*;
import java.util.*;

// 백준 RGB 1 문제는 그냥 최소값만 골라오면서 갱신했기 때문에 뭘 골라왔는지는 모른다
// 다시말하면 첫 번째 집과 끝의 집의 색이 다르게 하는 것이 불가능 하다는 것
// 그래서 이렇게 풀어야한다

// 첫 번째 집을 R로 칠했을 때, G로 칠했을 때, B로 칠했을 때를 고정해서 각각 따로따로 계산한다
// 첫 번째 집을 R로 어떻게 고정하냐고? -> R을 색칠하기 위한 비용은 그냥 두고 G,B부분을 1000보다 크게 해놓으면 됨
// 다음 집에서는 무조건 작은 것을 골라갈건데 어차피 MAX값이면 안뽑히는 거나 마찬가지니까
// 그리고 맨 마지막 집을 R을 제외하고 G나 B를 칠했을 때 중 작은 거를 채택하면됨
// 이렇게 세 번 반복하고 그 중 제일 작은 거를 답으로

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][3];
        int[][] dp = new int[N][3]; // 이거 3개 필요한 거 아니냐고 할 수 있는데 그냥 덮어씌우면 돼서 ㄱㅊ

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
            matrix[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int start=0; start<3; start++){ // start = 0 RED, start = 1 Green..
            for(int c=0; c<3; c++){
                if(c == start) dp[0][c] = matrix[0][c];
                else dp[0][c] = 1001;
            }
            for(int r=1; r<N; r++){
                dp[r][0] = matrix[r][0] + Math.min(dp[r-1][1], dp[r-1][2]);
                dp[r][1] = matrix[r][1] + Math.min(dp[r-1][0], dp[r-1][2]);
                dp[r][2] = matrix[r][2] + Math.min(dp[r-1][0], dp[r-1][1]);
            }

            for(int c=0; c<3; c++){
                if(start != c) list.add(dp[N-1][c]); // 첫 번째 집에 칠했던 색은 제외하고 답 후보리스트에 넣는다
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
