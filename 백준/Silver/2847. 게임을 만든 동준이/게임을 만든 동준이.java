import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //반례 -> 4 4 5 6 4
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int total = 0;
        int temp = arr[N-1]-1;
        for(int i=N-1; i>0; i--){
            if(arr[i-1] < temp) temp = arr[i-1]-1;
            else {
                total += arr[i - 1] - temp;
                temp--;
            }
        }
        System.out.println(total);
    }
}