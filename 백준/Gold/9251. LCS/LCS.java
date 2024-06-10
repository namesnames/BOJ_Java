import java.io.*;
import java.util.*;

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

