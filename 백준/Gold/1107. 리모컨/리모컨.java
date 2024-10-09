import java.io.*;
import java.util.*;
// 생각지 못한 부분이 많았다
// 일단 풀이는 1부터 999999까지 완탐
// 대소비교 해서 answer를 업데이트해 나갈텐데, 내가 고른 채널이 몇 번을 눌러야 되는지를 고려안했음
// 맨 마지막에 답 출력직전에만 해서 틀렸음
// 1555
// 3
// 0 1 9 로 테스트해보시길, 2222가 아니라 888이 답임

public class Main{
    static int N, answer, len;
    static List<Integer> list;
    static boolean[] trash;
    static int[] ten = new int[]{1,10,100,1000,10_000,100_000};
    static void check(){
        int num = 0;
        for(int i=0; i<list.size(); i++){
            num += ten[i] * list.get(list.size() -1 -i);
        }
        if(Math.abs(num - N) + list.size() < answer) {
            answer = Math.abs(num - N) + list.size();
        }
    }
    static void dfs(){
        if(!list.isEmpty()) check(); //하 비어있을 때도 체크하니까 답이 이상하게 나오지
        if(list.size() == 6){
            return;
        }

        for(int i=0; i<10; i++){
            if(!trash[i]){
                list.add(i);
                dfs();
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        trash = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
            for (int l : temp) {
                trash[l] = true;
            }
        }
        if(N == 100){
            System.out.println(0);
            return;
        }

        list = new ArrayList<>();
        len = 0;
        answer = Integer.MAX_VALUE;
        dfs();
        answer = Math.min(answer, Math.abs(N - 100));
        System.out.println(answer);
    }
}