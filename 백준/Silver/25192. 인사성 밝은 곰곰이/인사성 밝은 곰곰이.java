import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>(); //HashSet을 쓰는 이유 // HashMap는 key가 중복될 수 있어서 HashSet사용
        //그냥 파이썬의 Set과 같음 // {A,B,C}
        int cnt = 0;

        for(int i=0; i<N; i++){
            String cur = br.readLine();
            if(cur.equals("ENTER")){  // ENTER가 보이면 hashset초기화해야함
                hs = new HashSet<>();
            }
            else{
                if(!hs.contains(cur)){
                    hs.add(cur);
                    cnt ++;
                }
            }
        }
        System.out.println(cnt);
    }
}