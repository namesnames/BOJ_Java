class Solution {
    int[] diff;
    int[] time;
    int N;
    long Limit;
    
    boolean check(int level)
    {
        long temp = 0;
        for(int i=0; i<N; i++)
        {
            if(diff[i] <= level) temp += time[i];
            else 
            {
                temp += time[i] + (diff[i] - level) * (time[i-1] + time[i]);
            }
        }
        
        if(temp <= Limit) return true;
        else return false;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        Limit = limit;
        
        //숙련도 범위 1~100000(십만)
        N = diffs.length;
        diff = new int[N];
        for(int i=0; i<N; i++)
        {
            diff[i] = diffs[i];
        }
        
        time = new int[times.length];
        for(int i=0; i<times.length; i++)
        {
            time[i] = times[i];
        }
        
        int left = 1;
        int right = 100000;
        int mid = 0;
        while(left <= right)
        {
            mid = (left + right) / 2;
            
            if(check(mid)) //가능하면 더 줄이기
            {
                answer = mid;
                right = mid - 1;
            }
            else //불가능하면 늘려보기
            {
                left = mid + 1;
            }
            
        }
        
        // 가능하면 더 줄여보기
        return answer;
    }
}