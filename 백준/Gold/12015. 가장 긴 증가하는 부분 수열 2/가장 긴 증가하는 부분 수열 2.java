import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] dp;
    static List<Integer> list = new ArrayList<>();

    static int search(int start, int end, int target){

        int result = list.size()-1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(list.get(mid) > target){
                end = mid - 1;
                result = mid;
            }
            else if(list.get(mid) == target) return mid;
            else start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N];
        dp[0] = 1;


        list.add(arr[0]);
        for(int i=1; i<N; i++){
            if(arr[i] > list.get(list.size()-1)){
                list.add(arr[i]);
            }
            else if(arr[i] == list.get(list.size()-1)) continue;
            else list.set(search(0,list.size()-2, arr[i]),arr[i]);
        }

//        for(int l : list){
//            System.out.print(l + " ");
//        }
        System.out.println(list.size());
    }
}

