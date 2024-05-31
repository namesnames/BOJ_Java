import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 바로 답 입갤
// 생각해내서 푸는 건 진짜 쉽지 않음

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[91];

        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<91; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);

    }
}
