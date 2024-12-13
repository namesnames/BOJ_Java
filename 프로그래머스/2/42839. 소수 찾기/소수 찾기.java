import java.util.*;

class Solution {
    static int N;
    static int answer;
    static String str;
    static List<Character> list;
    static HashSet<Integer> set;
    static boolean[] V;
    
    static boolean check(int n) {
		if(n<2) return false;
		
		for(int i=2; i*i<=n; i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}
    static void dfs(int depth, int limit){       
        if(list.size() == limit){
            String temp = "";
            for(Character c : list){
                temp += c;
            }
            int num = Integer.parseInt(temp);
            
            if(check(num)) {
                if(!set.add(num)) {}
                else answer++;
            }
            return;
        }
        for(int i=0; i<N; i++){
            if(!V[i]){
                V[i] = true;
                list.add(str.charAt(i));
                dfs(depth + 1, limit);
                V[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    
    public int solution(String numbers) {
        answer = 0;
        str = numbers;
        // 1 7
        // 0 1 1
        // 1자리부터 7자리까지 완탐
        // 다 만들어보고 
        N = numbers.length();
        set = new HashSet<>();
        for(int i=1; i<=N; i++){
            V = new boolean[N];
            list = new ArrayList<>();
            dfs(0,i);
        }
        return answer;
    }
}