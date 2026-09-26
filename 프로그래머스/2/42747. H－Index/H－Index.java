class Solution {
    int[] C;
    
    boolean check(int mid)
    {
        int up = 0;
        int down = 0;
        
        for(int c : C)
        {
            if(c >= mid) up++;
            else if(c < mid) down++;
        }
        
        if(up >= mid && down <= mid) return true;
        else return false;
    }
    public int solution(int[] citations) {
        int answer = 0;
        
        this.C = citations;
        
        int left = 0;
        int right = 10000;
        
        while(left <= right)
        {
            int mid = (left + right) / 2;
            
            if(check(mid)) 
            {
                left = mid + 1;
                answer = mid;
            }
            else right = mid - 1;
        }
        return answer;
    }
}