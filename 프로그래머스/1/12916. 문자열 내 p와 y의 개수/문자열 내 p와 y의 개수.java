class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        
        int p = 0;
        int y = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == 'p'){
                p++;
            }
            else if(c == 'y'){
                y++;
            }
        }
        
        if(p == y){
            answer = true;
        }else{
            answer = false;
        }
        
        return answer;
    }
}