import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long h = (N - 1) / 2;
        long a = h * (N - h - 1);

        // divisors에 약수 넣기
        List<Integer> divisors = new ArrayList<>();
        for(int i=1; i*i<=N; i++){
            if(N % i == 0) {
                if(i*i == N) divisors.add(i);
                else {
                    divisors.add(i);
                    divisors.add(N/i);
                }
            }
        }
        Collections.sort(divisors);
        int len = divisors.size();
        int b = 0;
        for(int i=0; i<len-1; i++){ // 3중 for문으로 브루트포스
            for(int j=i; j<len-1; j++){
                int x = divisors.get(i);
                int y = divisors.get(j);
                for(int k=j+1; k<len; k++){
                    if(divisors.get(k) == x+y){
                        b++;
                        break;
                    }
                }
            }
        }

        boolean[] eratos = new boolean[N+1];
        eratos[1] = true;
        for(int i=2; i<=N; i++){
            for(int j= i+i; j<=N; j+=i){
                eratos[j] = true;
            }
        }
        int c = 0;
        for (int i = 5; i <= N; i += 2)
            c += (eratos[i] || eratos[i - 2] ? 0 : 1);


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

