import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        long[] B = new long[N];
        long[] C = new long[N];
        long[] D = new long[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            A[i] = a;
            B[i] = b;
            C[i] = c;
            D[i] = d;
        }

        long[] AB = new long[N*N];
        long[] CD = new long[N*N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                AB[i*N + j] = A[i] + B[j];
                CD[i*N + j] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int left = 0;
        int right = N*N - 1;
        long answer = 0;

        while(left < N*N && right > -1){
            if(AB[left] + CD[right] < 0) left++;
            else if(AB[left] + CD[right] > 0 ) right--;
            else{
                long leftValue = AB[left];
                long rightValue = CD[right];
                int leftcnt = 1;
                int rightcnt = 1;

                while(left + 1 < N*N && AB[left+1] == leftValue){
                    left++;
                    leftcnt++;
                }
                while(right - 1 > -1 && CD[right-1] == rightValue){
                    right--;
                    rightcnt++;
                }
                answer += (long) leftcnt * rightcnt; // int * int 결과 자체가 int범위를 넘어갈 수 있기 때문에 (long)으로 타입캐스팅

                // 지금 상태는 배열에서 같은 값이 내 옆에 몇 개 있는지 확인한거라
                // 지금 상태로 while돌면 합이 계속 0일테니 움직여준다
                left++;
                right--;
            }
        }
        System.out.println(answer);
    }
}