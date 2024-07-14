import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String command = br.readLine(); // RDD
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            Deque<Integer> dq = new ArrayDeque<>();
            for(int i=0; i<n; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            int rcnt = 0;
            boolean check = false;
            for(int i=0; i<command.length(); i++){
                if(command.charAt(i) == 'R') rcnt++;
                else{
                    if(dq.isEmpty()){
                        System.out.println("error");
                        check = true;
                        break;
                    }
                    if(rcnt % 2 == 1) dq.removeLast();
                    else dq.removeFirst();
                }
            }

            if(check) continue;

            List<Integer> list = new ArrayList<>(dq);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(rcnt % 2 == 1){
                for(int i=list.size()-1; i>-1; i--){
                    if(i == 0) {
                        sb.append(list.get(i));
                        break;
                    }
                    sb.append(list.get(i)).append(",");
                }
            }
            else{
                for(int i=0; i<list.size(); i++){
                    if(i == list.size()-1) {
                        sb.append(list.get(i));
                        break;
                    }
                    sb.append(list.get(i)).append(",");
                }
            }
            sb.append("]");
            System.out.println(sb);
        }

    }
}