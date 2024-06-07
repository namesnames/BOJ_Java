import java.io.*;
import java.util.*;

// 투 포인터
// for문으로 배열 쭉 돌면서 그 때 기준으로 start, end 정해서 투 포인터 돌린다.

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long minA = Long.MAX_VALUE;
        long minB = Long.MAX_VALUE;
        long minC = Long.MAX_VALUE;
        long min = Long.MAX_VALUE;
        for(int i=0; i<N-2; i++){
            int pin = i;
            int start = i+1;
            int end = N-1;

            while(start < end){
                long value = arr[pin] + arr[start] + arr[end];
                if(Math.abs(min) > Math.abs(value)) {
                    min = value;
                    minA = arr[pin];
                    minB = arr[start];
                    minC = arr[end];
                }

                if(value == 0) {
                    System.out.println(arr[pin] + " " + arr[start] + " " + arr[end]);
                    return;
                }
                else if(value > 0 ) end--; // 0보다 크면 오른쪽을 줄이고
                else start ++;
            }
        }
        System.out.println(minA + " " + minB + " " + minC);
    }
}
