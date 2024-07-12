import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long K;

    static long check(int S){
        long sum = 0;
        for(int i=1; i<=N; i++){
            sum += Math.min(S/i, N);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Long.parseLong(br.readLine());


        int start = 1;
        int end = 1_000_000_000;
        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            long val = check(mid);

            if(val >= K) {
                result = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        System.out.println(result);

    }
}