import java.io.*;
import java.util.*;

public class Main {
    // N이 1일때 분기처리는 그냥 if(N==1) 머시기 return으로 하자
    // 주의할점 -> 1,5 2,4 와 같이 입력이 들어올 때를 대비 -> 다음녀석의 종료시간(4)이 end(5) 커야만 end를 갱신해야함
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] temp = new int[]{a,b};
            list.add(temp);
        }

        Collections.sort(list, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               if(o1[0] == o2[0]) return o1[1] - o2[1];
               else return o1[0] - o2[0];
           }
        });

        int[] temp = list.get(0);
        int start = temp[0];
        int end = temp[1];
        long total = 0;

        if(N==1){  // 분기처리는 else쓰지말고
            System.out.println(end - start);
            return; //이렇게 return하자
        }

        for (int i = 1; i < N; i++) {
            int[] temp2 = list.get(i);
            if (temp2[0] > end) { // 다음 녀석의 시작이 end보다 클 때 선길이 계산
                total += (end - start);
                start = temp2[0];
                end = temp2[1];
            } else { // 다음녀석이 겹치거나 연결돼있으면 end만 수정
                if (temp2[1] > end) { // 그것도 다음녀석의 종료부분이 end보다 클 때만 1,5 2,4 입력 대비
                    end = temp2[1];
                }
            }

            if (i == N - 1) total += (end - start); // 마지막이면 그냥 길이 계산
        }
        System.out.println(total);

    }
}

