import java.io.*;
import java.util.*;

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

        List<Integer> record = new ArrayList<>();
        candidate.add(arr[0]);
        record.add(0); //arr[0]은 candidate의 0번째에 들어간다

        for(int i=1; i<N; i++){
            int len = candidate.size();
            int now = candidate.get(len-1);

            if(arr[i] > now) {
                candidate.add(arr[i]);
                record.add(candidate.size()-1);
            }
            else if(arr[i] < now) {
                int idx = search(0,len-2,arr[i]);
                candidate.set(idx,arr[i]);
                record.add(idx);
            }
        }
        System.out.println(N-candidate.size());

        List<Integer> answer = new ArrayList<>();
        int max = candidate.size()-1;
        for(int i=N-1; i>-1; i--){
            if(record.get(i) != max){
                answer.add(arr[i]);
            }
            else max--;
        }
        Collections.sort(answer);
        for(int a : answer){
            System.out.println(a);
        }

    }
}

