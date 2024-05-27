class Solution {
    public int solution(int N) {
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(N % i == 0){
                answer += i;
            }
        }
        return answer;
    }
}