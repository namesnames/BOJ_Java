import java.io.*;
import java.util.*;

public class Main{
    static int N, num;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static boolean[] V;
    static String OriginStr;

    static void recur(){
        String str = "";
        for(int i=0; i<list.size(); i++){
            str += Integer.toString(list.get(i));
        }

        int len = str.length();
        boolean check = true;
        for(int i=0; i<len; i++){
            if(str.charAt(i) != OriginStr.charAt(i)) check = false;
        }

        if(!check) return;
        else if(check && len == N){
            for(int i=0; i<list.size(); i++){
                System.out.print(list.get(i) + " ");
            }
            System.exit(0); // return 만으로는 안끝남 // 계속 진행돼서 나중에 인덱스 에러남
        }

        for(int i=1; i<num+1; i++){
            if(V[i] == false){
                V[i] = true;
                list.add(arr[i]);
                recur();
                V[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        OriginStr = br.readLine();
        N = OriginStr.length();

        num = 0;
        if(N >= 10) num = 9 + (N-9) / 2;
        else num = N;

        arr = new int[num+1];
        V = new boolean[num+1];

        for(int i=1; i<num+1; i++){
            arr[i] = i;
        }
        recur();
    }
}