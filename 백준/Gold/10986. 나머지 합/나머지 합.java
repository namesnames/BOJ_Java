import java.io.*;
import java.util.*;


public class Main{
    static long cal(long n){
        return n * (n-1) / 2;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        long[] remain = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        for(int i=1; i<N; i++){
            arr[i] += arr[i-1];
        }
        for(int i=0; i<N; i++){
            arr[i] = arr[i] % M;
        }

        for(int i=0; i<N; i++){
            remain[(int)arr[i]]++;
        }

        long answer = 0;
        answer += remain[0];
        for(int i=0; i<M; i++){
            if(remain[i] >= 2){
                answer += cal(remain[i]);
            }
        }
        System.out.println(answer);
    }
}