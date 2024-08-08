import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean search(int left, int right, int target, int idx){
        boolean check = false;
        boolean flag = false;
        while(left < right){
            if(left == idx && !flag){
                if(left + 1 == right) break;
                left++;
                flag = true;
                continue;
            }
            if(right == idx && !flag){
                if(right - 1 == left) break;
                right--;
                flag = true;
                continue;
            }

            int num = arr[left] + arr[right];
            if(num < target) left++;
            else if(num > target) right--;
            else {
                //System.out.println("target " + target + " left " + arr[left] + " right " + arr[right]);
                check = true;
                break;
            }
        }
        return check;
    }
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = 0;
        for(int i=N-1; i>-1; i--){
            if(search(0,N-1, arr[i], i)) answer++;
        }

        System.out.println(answer);
    }
}
