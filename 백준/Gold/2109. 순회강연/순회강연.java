import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        int dMax = 0;
        for(int i=0; i<N; i++){
             st = new StringTokenizer(br.readLine());
             int p = Integer.parseInt(st.nextToken());
             int d = Integer.parseInt(st.nextToken());
             dMax = Math.max(dMax, d); //최대 일 수  = 2
             list.add(new int[]{d,p,0});
        }

        int[] dp = new int[dMax+1]; // 0 1 2
        Collections.sort(list, (a,b) -> {return a[0] - b[0];});

        for(int i=dMax-1; i>-1; i--){ // 1,0
            int flag = 0;
            int max = 0;
            boolean check = true;
            for(int j=0; j<list.size(); j++) {
                int[] temp = list.get(j);
                if (temp[2] == 0 && temp[0] >= i + 1) { //안가보고 + 일수가 가능이면
                    if (max <= temp[1]) {
                        max = temp[1];
                        flag = j;
                        check = false; //찾았다
                    }
                }
            }
            //최댓값 못 찾았으면
            if(check) {
                dp[i] = dp[i+1];
            }
            else {
                dp[i] = dp[i+1] + max;
                list.get(flag)[2] = 1;
            }

        }
        System.out.println(dp[0]);
    }
}
