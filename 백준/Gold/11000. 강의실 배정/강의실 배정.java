import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        // 가장 많이 겹치는 시간대가 몇 개인지 세는 문제-> PQ사용(종료시간을 PQ에 넣고 제일 클 때를 check)
        // 시작시간 오름차순 + 시작시간같으면 종료시간 오름차순으로 하면 ArrayList로 충분히 할 수 있지 않냐고?
        // ㄴㄴ 1 3, 2 4... 이렇게 들어오면 어떻게 할건데
        // 근데 PQ를 사용해서 넣으면 오름차순으로 계속 정렬시켜줌
        // peek() 쓰면 맨 앞값 return, poll()쓰면 맨 앞값 반환하면서 삭제
        
        // 풀이
        // 시작시간 기준으로 오름차순으로 정렬
        // 우선순위큐에 종료시간을 넣음
        // 다음 녀석의 시작시간이 pq의 맨 앞의 값보다 크거나 같으면 pq의 맨앞 원소 빼고
        // 다음 녀석의 종료시간을 넣음
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] temp = new int[]{a,b};
            list.add(temp);
        }

        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] temp = list.get(0);
        pq.add(temp[1]);
        int maxNum = 0;

        for(int i=1; i<N; i++){
            temp = list.get(i);
            if(pq.peek() <= temp[0]){ // 다음녀석의 시작시간이 pq의 맨 앞 값보다 크거나 같으면 안겹친다는 거니까 
                pq.poll(); //맨 앞 값 지우고
                pq.add(temp[1]); //다음 녀석의 종료시간 넣기
            }
            else{
                pq.add(temp[1]); //
            }
            maxNum = Math.max(maxNum, pq.size());
        }
        System.out.println(maxNum);
    }
}