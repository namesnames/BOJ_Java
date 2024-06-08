import java.io.*;
import java.util.*;

public class Main {

    static boolean[] alphabet = new boolean[26];
    static int K;
    static ArrayList<String> list = new ArrayList<>();
    static int max = 0;

    static int check(){
        int cnt = 0;
        for(int i = 0; i < list.size(); i++){
            String temp = list.get(i);
            boolean flag = true;
            for(int j = 0; j < temp.length(); j++){
                if(alphabet[temp.charAt(j) - 97] != true) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) cnt++;
        }
        return cnt;
    }

    // 모든 알파벳들 중에서 K개를 뽑는 함수
    static void cal(int start, int depth){
        if(depth == K-5) {
            max = Math.max(max,check());
            return;
        }
        for(int i = start; i < 26; i++){
            if(alphabet[i]) continue;
            alphabet[i] = true;
            cal(i+1, depth+1);
            alphabet[i] = false;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        alphabet[0] = alphabet[2] = alphabet[8] = alphabet[13] = alphabet[19] = true;

        if(K < 5) {
            System.out.println(0);
            return;
        }
        else if(K == 26) {
            System.out.println(N);
            return;
        }
        else {
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                temp.replace("anta", "");
                temp.replace("tica", "");
                list.add(temp);
            }
            cal(1,0);

        }
        System.out.println(max);
    }
}

