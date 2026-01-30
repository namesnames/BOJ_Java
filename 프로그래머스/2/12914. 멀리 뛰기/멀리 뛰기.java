class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] list = new long[n+1];
        
        if(n == 1 || n == 2) return n;
        
        list[1] = 1;
        list[2] = 2;
        
        for(int i=3; i<n+1; i++)
        {
            list[i] = (list[i-1] + list[i-2]) % 1234567;
        }
        
        return list[n];
    }
}