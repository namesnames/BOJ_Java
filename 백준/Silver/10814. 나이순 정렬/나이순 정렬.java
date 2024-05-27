import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] s1, String[] s2){
                    if(s1[0] == s2[0]){
                        return 1; //나이가 같으면 그대로
                    }
                    else{
                        return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
                    }
            }
        });

        for(String[] a : arr){
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }

        bw.append(sb);
        bw.flush();
    }
}
