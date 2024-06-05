import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0; i<M; i++){
            long num = arr[0] + arr[1];
            arr[0] = num;
            arr[1] = num;
            Arrays.sort(arr);
        }

        long answer = 0;
        for(long a : arr){
            answer += a;
        }
        System.out.println(answer);
    }
}
