import java.util.*;

class Solution {
    
    // s길이가 6이면 x는 5까지만
    // check는 ArrayDeque으로
    static List<Character> list;
    static Deque<Character> dq;
    
    static boolean check(){
        //맨 앞부터 넣고 시작
        dq.clear();
        dq.add(list.get(0));
        for(int i=1; i<list.size(); i++){
            if(dq.isEmpty()){ //dq가 비어있으면
                dq.add(list.get(i));
            }
            else{ //비어있지않으면
                if(dq.peekLast() == '['){
                    if(list.get(i) == ']') dq.removeLast();
                    else dq.add(list.get(i));
                }
                else if(dq.peekLast() == '('){
                    if(list.get(i) == ')') dq.removeLast();
                    else dq.add(list.get(i));
                }
                else if(dq.peekLast() == '{'){
                    if(list.get(i) == '}') dq.removeLast();
                    else dq.add(list.get(i));
                }
                else dq.add(list.get(i));
            }
        }
        if(dq.isEmpty()) return true;
        else return false;
    }
    
    public int solution(String s) {
        int answer = 0;
        
        list = new ArrayList<>();
        dq = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            list.add(s.charAt(i));
        }
        
        if(check()) answer++;
        for(int i=1; i<s.length(); i++){
            char c = list.get(0);
            list.remove(0);
            list.add(c);
            if(check()) answer++;
        }
        return answer;
    }
}