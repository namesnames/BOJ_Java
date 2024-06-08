import java.io.*;
import java.util.*;

public class Main {

    static int plus;
    static int minus;
    static int multi;
    static int divide;
    static int result;
    static int[] arr;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void dfs(int depth, int result, int plus, int minus, int multi, int divide){
        if(depth == N){
            if(result > max) max = result;
            if(result < min) min = result;
            return;
        }
        if(plus > 0) dfs(depth+1, result + arr[depth], plus-1, minus, multi, divide);
        if(minus > 0) dfs(depth+1, result - arr[depth], plus, minus-1, multi, divide);
        if(multi > 0) dfs(depth+1, result * arr[depth], plus, minus, multi-1, divide);
        if(divide > 0) dfs(depth+1, result / arr[depth], plus, minus, multi, divide-1);
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multi = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());


        result = arr[0];
        dfs(1, result, plus, minus, multi, divide);
        System.out.println(max);
        System.out.println(min);
    }
}
