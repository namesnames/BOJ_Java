import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// https://kwanghyuk.tistory.com/4
// 어차피 마지막 계단은 항상 밟아야 하므로
// dp를 [내가 지금 이 계단을 밟을 때 최대 값]을 저장하도록 하고 답을 dp맨 마지막 원소를 출력하자
// "지금 이 계단"을 밟았을 때 가능한 경우는 아래 2가지임
//    O X O -> 전전칸밟고 jump후 지금 이 칸 -> dp[i-2] + arr[i]
//  O X O O -> 전전전칸밟고 jump후 전칸, 지금이 칸 밟는 경우 -> dp[i-3] + arr[i-1] + arr[i]
// 이 두 경우 중 큰 녀석을 dp[i]에 저장해나가면 됨
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        
        if(N == 1){
            System.out.println(arr[0]);
        }
        else if(N == 2){
            System.out.println(arr[0]+arr[1]);
        }
        else {
            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
            
            for(int i=3; i<N; i++){
                dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
            }
            System.out.println(dp[N-1]);
        }
    }
}
