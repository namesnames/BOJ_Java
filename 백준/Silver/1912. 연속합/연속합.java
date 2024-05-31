import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxNum = arr[0];
        for(int i=1; i<N; i++){
            arr[i] = Math.max(arr[i-1]+arr[i], arr[i]);
            maxNum = Math.max(maxNum,arr[i]);
        }

        System.out.println(maxNum);
    }
}
