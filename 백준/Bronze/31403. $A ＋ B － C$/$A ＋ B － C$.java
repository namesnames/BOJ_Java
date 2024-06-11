import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int Ia = Integer.parseInt(a);
        int Ib = Integer.parseInt(b);
        int Ic = Integer.parseInt(c);
        System.out.println(Ia+Ib-Ic);
        String ab = a+b;
        int Iab = Integer.parseInt(ab);
        System.out.println(Iab-Ic);


    }
}

