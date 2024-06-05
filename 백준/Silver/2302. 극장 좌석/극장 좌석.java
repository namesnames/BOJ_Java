import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4; i<41; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        int[] arr= new int[M+2];
        arr[0] = 0;
        for(int i=1; i<M+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[M+1] = N+1;

        int total = 1;
        for(int i=1; i<M+2; i++){
            total *= dp[arr[i] - arr[i-1]-1];
        }

        System.out.println(total);
    }
}
