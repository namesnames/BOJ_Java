import java.io.*;
import java.util.*;

// LCS는 외워야함
// 문자열 2개를 가로 세로에 배치해서
// 문자 하나씩 비교해감
// 두 문자가 같으면 dp[r][c] = dp[r-1][c-1] + 1
// 다르면 dp[r][c] = max(dp[r-1][c], dp[r][c-1])

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

        System.out.println(dp[N][M]);
    }
}

