import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 백준 "탑"이랑 비슷한 문제
        // 지금 들어올 놈과 스택의 top 비교
        // 들어올 놈이 더 크면 top 지우고 난 다음의 top과 또 비교 -> while -> 이러다 스택 텅텅비면 -1
        // 지금 들어올 놈이 작으면 그냥 stack에 넣는다

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(arr[N-1]);

        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for(int i=N-2; i>-1; i--){
            while(true){
                if(dq.getLast() <= arr[i]) {
                    dq.removeLast();
                    if(dq.isEmpty()){
                        list.add(-1);
                        dq.add(arr[i]);
                        break;
                    }
                }
                else {
                    list.add(dq.getLast());
                    dq.add(arr[i]);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>-1; i--){
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}

