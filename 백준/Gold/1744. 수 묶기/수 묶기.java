import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0) plus.add(num);
            else minus.add(num);
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        int i=0;
        int total = 0;
        while(i<plus.size()){
            if(i+1 < plus.size() && plus.get(i) != 1 && plus.get(i+1) != 1){
                total += plus.get(i++) * plus.get(i++);
            }
            else total += plus.get(i++);
        }

        i = 0;
        while(i<minus.size()){
            if(i+1 < minus.size()){
                total += minus.get(i++) * minus.get(i++);
            }
            else total += minus.get(i++);
        }

        System.out.println(total);
    }
}