import java.io.*;
import java.util.*;

public class no3107 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bfr.readLine();

        if (str.contains("::")) {
            str = str.replace("::", ":instd:");
        }

        String[] ipv6 = str.split(":");

        List<String> ip = new ArrayList<>();

        for (int i = 0; i < ipv6.length; i++) {
            String s = ipv6[i];
            if (s.isEmpty()) continue;
            for (int length = s.length(); length < 4; length = s.length()) s = "0" + s;

            ip.add(s);
        }

        int groupLen = 8 - ip.size() + 1;
        String[] result = new String[8];
        int idx = 0;
        for (String ips : ip) {
            if (ips.equals("instd")) {
                for (int remain = groupLen; remain > 0; remain--) result[idx++] = "0000";
            } else result[idx++] = ips;
            
        }
        for (int i = 0; i < result.length; i++) {
            bfw.write(result[i]);
            if (i < result.length - 1) {
                bfw.write(":");
            }
        }
        
        bfw.flush();
    }
}