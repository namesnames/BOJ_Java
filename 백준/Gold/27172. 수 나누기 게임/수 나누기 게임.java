import java.io.*;
import java.util.*;

// https://kyr-db.tistory.com/391

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] check = new boolean[1000001];
        int[] point = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            check[num] = true;
        }

        for(int a : arr){
            for(int i= a*2; i<1000001; i = a+i){
                if(check[i]){
                    point[a]++;
                    point[i]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int a : arr){
            sb.append(point[a] + " ");
        }
        System.out.println(sb);
    }
}
