import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static String[] strArr;
    static int target;
    static int cnt;
    static int answer;

    static int check(){
        int result = 0;
        for(String str : strArr){
            boolean flag = true;
            for(int i=0; i<str.length(); i++){
                if(arr[str.charAt(i) - 'a'] == 0){
                    flag = false;
                    break;
                }
            }
            if(flag) result++;
        }
        return result;
    }

    static void dfs(int idx){
        if(cnt == target){
            answer = Math.max(answer, check());
            return;
        }
        if(idx == 26) return;

        for(int i=idx; i<=25; i++){
            if(arr[i] == 0){
                arr[i] = 1;
                cnt++;
                dfs(i+1);
                arr[i] = 0;
                cnt--;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[26];
        arr[0] = 1;
        arr['t' - 'a'] = 1;
        arr['i'- 'a'] = 1;
        arr['c' - 'a'] = 1;
        arr['n' - 'a'] = 1;

        strArr = new String[N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            int len = str.length();
            strArr[i] = str.substring(4,len-4);
        }
        target = K-5;
        cnt = 0;
        dfs(0);
        System.out.println(answer);
    }
}
