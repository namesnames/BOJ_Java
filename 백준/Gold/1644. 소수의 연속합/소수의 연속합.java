import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] eratos = new int[N+1];
        for(int i=2; i<=N; i++){
            for(int j=i+i; j<=N; j+=i){
                eratos[j] = -1;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=N; i++){
            if(eratos[i] == 0){
                list.add(i);
            }
        }

        int left = -1;
        int right = -1;
        int answer = 0;
        int sum = 0;
        int len = list.size();

        while(left <= right){ // left 범위 컨트롤
            if(sum < N){
                right++;
                if(right == len) break; // 인덱스 범위 넘어가면 break (right 범위 컨트롤)
                sum += list.get(right);
            }
            else if(sum > N){
                left++;
                sum -= list.get(left);
            }
            else{
                answer++;
                left++;
                sum -= list.get(left);
            }
        }
        System.out.println(answer);
    }
}