//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        long[] arr = new long[N];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i=0; i<N; i++){
//            arr[i] = Long.parseLong(st.nextToken());
//        }
//
//        int start = 0;
//        int end = N-1;
//        int A = 0;
//        int B = 0;
//        long minNum = Long.MAX_VALUE;
//
//        while(start < end){
//            long sum = arr[start] + arr[end];
//            if(Math.abs(sum) < minNum){
//                A = start;
//                B = end;
//                minNum = Math.abs(sum);
//            }
//            if(sum >= 0) {
//                end--;
//            }else{
//                start++;
//            }
//
//        }
//        System.out.println(arr[A]+" "+arr[B]);
//
//
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 투포인터
        // 현재 오름차순으로 정렬 돼 있어서 왼쪽이 제일 작고 오른쪽이 제일 큰 상황
        // 양끝에서 접근해 올텐데 두 포인터의 합이 0보다 크면 오른쪽을 당기고 (합을 좀 줄여야 하니까)
        // 두 포인터의 합이 0보다 작으면 왼쪽을 민다 (합을 좀 키워야 하니까)

        int start = 0;
        int end = N-1;
        int A = 0;
        int B = 0;
        long minNum = Long.MAX_VALUE;

        while(start < end){
            long sum = arr[start] + arr[end];

            if(minNum > Math.abs(sum)){
                minNum = Math.abs(sum);
                A = start;
                B = end;
            }
            if(sum >= 0){
                end--;
            }else{
                start++;
            }
        }
        System.out.println(arr[A]+" "+arr[B]);

    }
}