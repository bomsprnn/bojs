import java.io.*;
import java.util.Stack;

public class no9012 { //14308	128
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < n; i++) {
            String s = bfr.readLine();
            int len = s.length();


            for (int j = 0; j < len; j++) {

                if (s.charAt(j) == '(') stack.push('('); //push
                else { // pop
                    if (stack.isEmpty()) {
                        stack.push(')'); // ( 이 없는데 ) 나오면 -> break
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) bfw.write("YES\n");
            else bfw.write("NO\n");
            stack.clear();
        }

        bfw.flush();
    }
}
