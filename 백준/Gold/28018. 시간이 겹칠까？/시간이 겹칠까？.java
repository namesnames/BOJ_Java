import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr[S]++;
            if(E < 1_000_000) arr[E+1]--; // 종료시간에 바로 선택될 수 없다

        }

        int Q = Integer.parseInt(br.readLine());
        int[] want = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++){
            want[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=2; i<1000001; i++){
            arr[i] = arr[i] + arr[i-1];
        }
        StringBuilder sb = new StringBuilder();

        for(int w : want){
            sb.append(arr[w]).append("\n");
        }

        System.out.println(sb);
    }
}

