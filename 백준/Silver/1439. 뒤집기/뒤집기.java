import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int one = 0;
        int zero = 0;
        if(str.charAt(0) == '1') one++;
        else zero++;

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i-1) == '0' && str.charAt(i) == '1') one++;
            else if(str.charAt(i-1) == '1' && str.charAt(i) == '0') zero++;
        }

        int answer = Math.min(one,zero);
        System.out.println(answer);

    }
}

