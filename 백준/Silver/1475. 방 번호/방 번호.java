import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] slist = str.split("");
        int[] arr = new int[9]; // 8까지만 들어감
        int cnt = 0;
        for(String s:slist){
            int temp;
            temp = Integer.parseInt(s);
            if(temp == 9 || temp == 6){
                cnt++;
                continue;
            }
            arr[temp]++;
        }
        Arrays.sort(arr);
        int maxNum = arr[8];

        if(cnt+1/2 > maxNum){
            System.out.println((cnt+1)/2);
        }else{
            System.out.println(maxNum);
        }
        
    }
}
