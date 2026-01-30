class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int now_server = 0;
        int diff = 0;
        int plus_server = 0;
        int remain = 0;
        int[] history = new int[24];
        
        for(int i=0; i<24; i++)
        {
            if(i-k >= 0)
            {
                now_server -= history[i - k];
            }
            
            diff = players[i] - (now_server * m);
            
            if(diff < 0) plus_server = 0;
            else plus_server  = diff / m;                        
            
            now_server += plus_server;
            history[i] = plus_server;
            answer += plus_server;
        }
        
        for(int i=0; i<24; i++)
        {
            System.out.print(history[i] + " ");
        }
        System.out.println();
        System.out.println(now_server);
        return answer;
    }
}