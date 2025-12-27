class Solution {
    static int[] num;
    static int T,N;
    static int sum;
    static int answer;
    
    static void dfs(int i, int sum)
    {
        if(i == N)
        {
            if(sum == T) answer++;
            return;
        }
        
        dfs(i+1, sum + num[i]);
        dfs(i+1, sum - num[i]);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        
        num = new int[N];
        num = numbers.clone();
        T = target;
        
        sum = 0;
        dfs(0, 0);
        
        return answer;
    }
}