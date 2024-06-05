import java.io.*;
import java.util.*;

public class Main {

    static int[] Sarr;
    static int N;

    public static int check(int target){
        int start = 0;
        int end = N-1;
        while(start <= end){
            int mid = (start+end) / 2;
            if(Sarr[mid] == target) return 1;
            if(Sarr[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Sarr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Sarr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Sarr);

        int M = Integer.parseInt(br.readLine());
        int[] Carr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            Carr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            System.out.print(check(Carr[i]) + " ");
        }

    }
}
