import java.io.*;
import java.util.*;
// 백준 12015번 (가장 긴 증가하는 부분 수열 2)이랑 똑같은 풀이로 품
// N이 100이라 그러지 않아도 되는데 전깃줄2 풀다가 와서

public class Main {
    static int[] arr;
    static List<int[]> list = new ArrayList<>();
    static List<Integer> candidate = new ArrayList<>();

    static int search(int start, int end, int target){
        int result = candidate.size()-1;

        // target<= x < 마지막 요소
        while(start <= end){
            int mid = (start + end) / 2;
            if(candidate.get(mid) > target){
                result = mid;
                end = mid - 1;
            }
            else if(candidate.get(mid) == target) return mid;
            else start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b});
        }

        Collections.sort(list, (a,b)->{
            return a[1] - b[1];
        });

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = list.get(i)[0];
        }

        candidate.add(arr[0]);
        for(int i=1; i<N; i++){
            int len = candidate.size();
            int now = candidate.get(len-1);

            if(arr[i] > now) candidate.add(arr[i]);
            else if(arr[i] < now) candidate.set(search(0,len-2,arr[i]),arr[i]);
        }
        System.out.println(N-candidate.size());


    }
}

