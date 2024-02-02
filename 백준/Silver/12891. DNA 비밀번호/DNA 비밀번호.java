
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String word = br.readLine();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        HashMap<Character, Integer> mission = new HashMap<>();
        mission.put('A', A);
        mission.put('C', C);
        mission.put('G', G);
        mission.put('T', T);

        HashMap<Character, Integer> target = new HashMap<>();
        target.put('A', 0);
        target.put('C', 0);
        target.put('G', 0);
        target.put('T', 0);

        int answer = 0;
        boolean flag = true;

        for (int i = 0; i < P; i++) {
            char charAtIndex = word.charAt(i);
            target.put(charAtIndex, target.get(charAtIndex) + 1);
        }

        for (char j : new char[]{'A', 'C', 'G', 'T'}) {
            if (target.get(j) < mission.get(j)) {
                flag = false;
            }
        }
        if (flag) {
            answer++;
        }

        for (int i = 1; i <= S - P; i++) {
            flag = true;
            char charAtPrevious = word.charAt(i - 1);
            char charAtNext = word.charAt(i + P - 1);

            target.put(charAtPrevious, target.get(charAtPrevious) - 1);
            target.put(charAtNext, target.get(charAtNext) + 1);

            for (char j : new char[]{'A', 'C', 'G', 'T'}) {
                if (target.get(j) < mission.get(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
