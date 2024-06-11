import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> LIS = new ArrayList<>();
    static int search(int start, int end, int target){

        // 여기 result 초기값도 0으로 하는 실수 그만..
        int result = LIS.size()-1; // 0~i-1번 째 중에서 [target<=x<마지막]을 만족하는 녀석을 못 찾았으면 LIS의 맨 마지막녀석과 바꿔야 하므로
        while(start <= end){
            int mid = (start + end) / 2;
            if(LIS.get(mid) > target){
                result = mid;
                end = mid - 1;
            }
            else if(LIS.get(mid) == target) return mid;
            else start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> record = new ArrayList<>();

        LIS.add(arr[0]);
        record.add(0);
        for(int i=1; i<N; i++){
            int lastNum = LIS.get(LIS.size()-1);
            if(arr[i] > lastNum){ //지금 녀석이 LIS의 마지막보다 크면
                LIS.add(arr[i]); //걍 넣는다
                record.add(LIS.size()-1); //지금 넣는 건 LIS의 마지막번 째에 들어감
            }
            else{ // 지금 녀석이 LIS보다 작거나 같다면
                int idx = search(0,LIS.size()-1,arr[i]); //LIS의 0번째~i-1번째 중에서 바꿀 위치를 찾는다 // LIS.size()-1말고 i-1로 넣는 실수 그만..
                LIS.set(idx,arr[i]); // idx번째 요소를 arr[i]로 교체
                record.add(idx); //지금 넣는 건 LIS의 idx번째에 들어감
            }
        }

        System.out.println(LIS.size());


        List<Integer> answer = new ArrayList<>();
        int max = LIS.size()-1;
        for(int i=N-1; i>-1; i--){
            if(record.get(i) == max){
                answer.add(arr[i]);
                max--;
            }
        }
        Collections.sort(answer);
        for(int a : answer){
            System.out.print(a + " ");
        }
    }
}

