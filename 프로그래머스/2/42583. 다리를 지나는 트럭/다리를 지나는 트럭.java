import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Deque<Integer> truck = new ArrayDeque<>();
        Deque<int[]> bridge = new ArrayDeque<>();
        
        for(Integer i : truck_weights) truck.add(i);
        
        int now_weight = 0;
        int time = 0;
        
        int first_in_truck = truck.pollFirst();
        now_weight += first_in_truck;
        bridge.add(new int[]{first_in_truck, 0});
        time++;
        
        while(!truck.isEmpty() || !bridge.isEmpty())
        {
            
            if(!bridge.isEmpty())
            {
                int[] temp = bridge.peek();
                if(temp[1] >= bridge_length) 
                {
                    int[] out_truck = bridge.pollFirst();
                    now_weight -= out_truck[0]; 
                }

                if(!truck.isEmpty() && now_weight + truck.peek() <= weight)
                {
                    int now_in_truck = truck.pollFirst();
                    now_weight += now_in_truck;
                    bridge.add(new int[]{now_in_truck, 0});
                }
            }
            
            for(int[] t : bridge)
            {
                t[1]++;
            }
            
            time++;
        }
        
        answer = time - 1;
        return answer;
    }
}