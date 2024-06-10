import java.io.*;
import java.util.*;

// https://www.youtube.com/watch?v=voklbG1wU8A 좋은 해설 영상
// 하던대로 dp로 하면 시간초과
// 아래 예시로 간단하게 설명하자면
// 10 20 10 30 40 10 12 14 16 18
// 일단 arraylist에 하나씩 넣어갈 건데 넣을 녀석이 list의 맨 마지막보다 크면 add
// 작으면 list의 요소들 중에 대체가 가능한지 check
// list = {10,20,30,40} 이 있을 때 12를 넣겠다하면
// 요소들 중에 12<=x<40을 만족하고 그들 중 맨 왼쪽에 있는 거랑 바꿔치기함 (list.set이용)
// 결국 list = {10,20,30,40} 에서
// list = {10,12,14,16,18}이 되는건데 대체해도 이 list의 전체길이는 바뀌지 않으니까
// for문 다 돌고 list의 길이를 출력하면 정답임

public class Main {
    static int[] arr;
    static int[] dp;
    static List<Integer> list = new ArrayList<>();

    static int search(int start, int end, int target){

        int result = list.size()-1;  //이건 이제 list = {10,12,14,40}인 상황에서 16을 넣으려고 하는 상황을 위함 // 16<=x<40을 못찾으면 그냥 list맨 끝인 40이랑 바꿔쳐야 하니까 
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

        System.out.println(list.size());
    }
}

