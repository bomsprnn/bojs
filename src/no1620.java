import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.Float.NaN;

public class no1620 {
    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] search = new String[k];
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap< String,Integer> map2 = new HashMap<>();

        for(int i =0; i<n;i++){
            String pok = bfr.readLine();
            map1.put(i+1,pok);
            map2.put(pok,i+1);
        }

        for(int i =0; i<k ; i++){
            search[i] = bfr.readLine();
        } //input list of search contents

        for (int i =0; i<k ;i++){
            if (49<=search[i].charAt(0) && search[i].charAt(0)<=57) // int
                bfw.write(map1.get(Integer.parseInt(search[i]))+"\n");
            else
                bfw.write(map2.get(search[i])+"\n");

        }
        bfr.close();
        bfw.flush();
        bfw.close();

    }
}
