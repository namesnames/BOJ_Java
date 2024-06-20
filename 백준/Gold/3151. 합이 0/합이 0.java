import java.io.*;
import java.util.*;

public class Main {

    //lower bound와 upper bound에 대한 이해
    // https://angxxu.tistory.com/17
    // target과 일치하는 값이 없더라도 lower bound와 upper bound는 값은 위치 값을 반환해서
    // up - low 해도 0임

    static int[] arr;
    static int lower_bound(int start, int end, int target){
        while(start < end){ // 같으면 무한루프 // 왜냐면 밑에 end = mid가 있으니까 start와 end가 같을 때는 무한루프에 빠질 수 있음
            int mid = (start + end) / 2;
            if(arr[mid] >= target) end = mid; // 값을 찾았을 때, end를 축소시켜야 하는데 mid도 답이었으니 포함해야함
            else start = mid + 1;
        }
        return end;
    }

    static int upper_bound(int start, int end, int target){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > target) end = mid;
            else start = mid + 1; // arr[mid]가 target과 같으면 mid포함 그 뒤는 다 버림
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long answer = 0;
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                int x = -(arr[i] + arr[j]);
                int low = lower_bound(j+1,N,x);
                int up = upper_bound(j+1,N,x);
                answer += up - low;
            }
        }
        System.out.println(answer);
    }
}
