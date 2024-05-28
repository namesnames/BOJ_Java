class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        
        int j = 0;
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                j = i;
                break;
            }
        }
        answer += String.valueOf(j);
        answer += "에 있다";
        return answer;
    }
}