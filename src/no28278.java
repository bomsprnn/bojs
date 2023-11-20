import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no28278 {

    public static void main(String[] args) throws IOException {

        LinkedList<Integer> stack = new LinkedList<>();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(bfr.readLine()); //count of test
        for (int i=0; i<n ;i++){
            st = new StringTokenizer(bfr.readLine());
            int c = Integer.parseInt(st.nextToken());
            switch (c){
                case 1: stack.push(Integer.parseInt(st.nextToken()));break;
                case 2:
                    if (stack.isEmpty()) {
                        bfw.write("-1"+"\n");
                    } else {
                        bfw.write(stack.pop()+"\n");
                    }break;
                case 3: bfw.write(stack.size()+"\n");break;
                case 4:
                    if (stack.isEmpty()) {
                        bfw.write("1"+"\n");
                    } else {
                        bfw.write("0"+"\n");
                    }break;
                case 5:
                    if (stack.isEmpty()) {
                        bfw.write("-1"+"\n");
                    } else {
                        bfw.write(stack.getFirst()+"\n");
                    }break;
                default: break;

            }


        }bfr.close();
        bfw.flush();
        bfw.close();


    }
}
