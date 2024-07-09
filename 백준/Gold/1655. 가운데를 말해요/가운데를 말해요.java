import java.io.*;
import java.util.*;

public class Main {
    // PQ 2개로 중간값을 계속 유지함
    // 오름차순 PQ랑 내림차순 PQ 2개를 이용하고
    // 내림차순 PQ의 peek가 항상 mid임
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 앞 = maxHeap, 뒤 = minHeap
        // 일단 무조건 앞에 넣는데
        // 뒤 사이즈가 더 크면 뒤에 넣어줌
        // 앞의 top > 뒤의 top이면 둘 이 swap

        Queue<Integer> maxheap = new PriorityQueue<>((a,b) -> {return b-a;});
        Queue<Integer> minheap = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(maxheap.size() > minheap.size()) minheap.add(num);
            else maxheap.add(num);

            //swap
            if(!minheap.isEmpty() && maxheap.peek() > minheap.peek()){
                minheap.add(maxheap.poll());
                maxheap.add(minheap.poll());
            }
            sb.append(maxheap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}

