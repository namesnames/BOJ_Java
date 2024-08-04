import java.io.*;
import java.util.*;

public class Main {
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 개어렵.. 다시 풀어도 못 풀듯
        // 3x2 모양을 계속 붙여나갈 생각이었음
        // ex) 3x8일 때는 3x2모양 4개를 붙여서 3*4=81 이런식으로
        // 아니면 3x6랑 3x2 붙이고 또 3x2랑 3x6붙이고 이런식으로
        // 하지만 그럼 중복되는 모양이 무조건 생김
        // 그래서 중복을 없애기 위해 
        // 3x2 모양에 3x6모양만 붙이고 (dp[6]xdp[2]), 유니크한 모양만 따로 2개 더하기로 함
        // 3x4, 3x6마다 유니크한 모양이 2개씩 생겨가지고 그것들만 추가로 더하기로함
        // 결국 점화식은 dp[8] = dp[6] x dp[2] + dp[4]x2 + dp[2]x2가 됨
        
        int[] dp = new int[31];
        dp[2] = 3;
        dp[4] = 11;
        for(int i=6; i<31; i++){
            if(i % 2 == 0){
                dp[i] += dp[i-2] * dp[2];
                for(int j=i-4; j>0; j--){
                    if(j % 2 == 0){
                        dp[i] += dp[j] * 2;
                    }
                }
                dp[i] += 2;
            }
        }
        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
    }
}
