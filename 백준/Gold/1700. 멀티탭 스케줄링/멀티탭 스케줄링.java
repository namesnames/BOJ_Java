import java.io.*;
import java.util.*;

public class Main {
    // 현재에서부터 가장 나중에 쓰일 녀석을 지금 플러그에서 빼자
    static Set<Integer> set = new HashSet<>();
    static int[] arr;
    static int K;

    static int find(int startIdx){
        //set에서 하나씩 빼보면서 언제가 가장 끝에 있는지 + 아예 못찾으면 얘를 뺸다
        int targetS = 0;
        int targetIdx = -1;
        for(int s : set){
            int findIdx = 0;
            for(int i=startIdx; i<K; i++){
                if(s == arr[i]) {
                    findIdx = i;
                    break;
                }
            }
            if(findIdx == 0) return s;
            if(findIdx > targetIdx){
                targetIdx = findIdx;
                targetS = s;
            }
        }
        return targetS;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int idx = 0;
        for(int i=0; i<K; i++){ // 처음에 플러그 꽂기
            if(set.size() == N){
                idx = i;
                break;
            }
            else set.add(arr[i]);
        }

        int cnt = 0;
        for(int i=idx; i<K; i++){
            // set에 있으면 넘어가고 없으면 하나 빼고 넣어야함
            if(set.contains(arr[i])) continue; // set에 있으면 pass
            else {
                set.remove(find(i+1)); //set에 없으면 빼는 로직 실행
                cnt++;
                set.add(arr[i]); // 뺐으면 새로 넣기

//                for(int s : set){
//                    System.out.print(s + " ");
//                }
//                System.out.println();
            }
        }
        System.out.println(cnt);

    }
}