import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];

        if(T[N-1] == 1) dp[N-1] = P[N-1];
        else dp[N-1] = 0;

        for(int i=N-2; i>-1; i--){
            if(i+T[i]-1 <= N-1){
                dp[i] = Math.max(dp[i+1], dp[i+T[i]]+P[i]);
            }
            else dp[i] = dp[i+1];
        }
        
        System.out.println(dp[0]);
    }
}
