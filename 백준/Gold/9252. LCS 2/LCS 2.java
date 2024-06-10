import java.io.*;
import java.util.*;
// 9251(LCS) + 역추적
// https://tussle.tistory.com/680

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int N = str1.length();
        int M = str2.length();

        int[][] dp = new int[N+1][M+1];

        for(int r=1; r<N+1; r++){
            for(int c=1; c<M+1; c++){
                if(str1.charAt(r-1) == str2.charAt(c-1)) dp[r][c] = dp[r-1][c-1] + 1;
                else dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
            }
        }

        // 역추적
        // 같을 때 dp[r][c] = dp[r-1][c-1] + 1 했고
        // 다를 때 dp[r][c] = max(dp[r-1][c], dp[r][c-1])했기 때문에 이거 반대로 간다
        // 우측최하단부터 시작하는데 만약 왼쪽 대각선으로 이동하게 되면 그걸 답에 add

        int r = N;
        int c = M;
        List<Character> answer = new ArrayList<>();
        while(r > 0 && c > 0){
            if(dp[r][c] == dp[r-1][c]) r--;
            else if(dp[r][c] == dp[r][c-1]) c--;
            else{
                answer.add(str1.charAt(r-1));
                r--;
                c--;
            }
        }
        System.out.println(dp[N][M]);
        for(int i=answer.size()-1; i>-1; i--){
            System.out.print(answer.get(i));
        }
    }
}

