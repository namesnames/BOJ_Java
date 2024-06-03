import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

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
            if(pq.peek() <= temp[0]){
                pq.poll();
                pq.add(temp[1]);
            }
            else{
                pq.add(temp[1]);
            }
            maxNum = Math.max(maxNum, pq.size());
        }
        System.out.println(maxNum);
    }
}