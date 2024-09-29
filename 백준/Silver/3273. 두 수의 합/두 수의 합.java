import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1 2 3 5 7 9 10 11 12
        // 일단 왼쪽꺼 먼저 ++
        // 작으면 왼쪽꺼 ++
        // 크면 오른쪽꺼 --

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        int answer = 0;
        while(left < right){
            int val = arr[left] + arr[right];
            if(val == x) {
                answer++;
                left++;
            }
            else if(val < x) left++;
            else if(val > x) right--;
        }
        System.out.println(answer);
    }
}