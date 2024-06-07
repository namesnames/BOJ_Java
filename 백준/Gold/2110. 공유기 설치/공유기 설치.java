import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int C;
    static int cnt;
    static int[] arr;

    public static boolean check(int d, int cnt){
        int pin = 0;
        for(int i = 1; i < N; i++){
            if(arr[i] - arr[pin] >= d){ //이 d를 이분탐색으로
                cnt--;
                pin = i;
            }
            if(cnt-1 == 0) {
                return true;
            }
        }
        return false; // 여기까지 오면 C개만큼 공유기를 설치하지 못했다는 의미니 false 반환
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = 1000000000;
        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            boolean flag = check(mid,C);
            if(flag == true) {
                result = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }

        System.out.println(result);

    }
}
