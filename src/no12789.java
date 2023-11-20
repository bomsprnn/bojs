import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class no12789 {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> stack = new LinkedList<>();
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bfr.readLine());
        st = new StringTokenizer(bfr.readLine());
        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }
        int num = 1;

        for (int i = 0; i < n; i++) {
            if (line[i] != num) {
                if (!stack.isEmpty() && stack.getFirst() == num) {
                    stack.pop(); i--; num++;
                } else {
                    stack.push(line[i]);
                }
            }else {
                num ++;
            }
        }

        for(int i=0; i<stack.size();i++){
            if (stack.getFirst()==num) {
                int c = stack.pop();
                num++;
            }
            else break;
        }
        if (stack.isEmpty()||stack.getFirst()==num){
            bfw.write("Nice");
        }else bfw.write("Sad");

        bfr.close();

        bfw.flush();
        bfw.close();

    }
}
