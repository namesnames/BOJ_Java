import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        for(int c=0; c<10; c++){
            dp[1][c] = 1;
        }
        dp[1][0] = 0;
        int mod = 1000000000;

        for(int r=2; r<N+1; r++){
            for(int c=0; c<10; c++){
                if(c == 0) dp[r][0] = dp[r-1][1] % mod;
                else if(c == 9) dp[r][9] = dp[r-1][8] % mod;
                else{
                    dp[r][c] = (dp[r-1][c-1] + dp[r-1][c+1]) % mod;
                }
            }
        }
        long answer = 0;
        for(int c=0; c<10; c++){
            answer += dp[N][c];
        }
        System.out.println(answer % mod);
    }
}
