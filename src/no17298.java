import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no17298 {//149796	1044
    public static void main(String[] args) throws IOException {
        /**
         * 오큰수 : 오른쪽에 있으면서 큰 수 중 가장 왼쪽에 있는 수
         * A의 오른쪽에서 가장 가까이 있는 A보다 큰 수
         * 없으면 -1
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n]; //입력받은 수열
        int[] result = new int[n]; //오큰수

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            //스택에서 뽑은 값이 들어오려는 값보다 작으면 오큰수!
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) { //오큰수
                result[stack.pop()] = arr[i];
                //stack.pop(); //오큰수를 찾았으니 버리기
            }
            stack.push(i); //못찾았으면 다음 수 들어올 때 까지 스택에서 얌전히 대기
        }
        while (!stack.isEmpty()) {
            result[stack.peek()] = -1;
            stack.pop();
        }
        for (int i = 0; i < n; i++) {
            bfw.write(result[i] + " ");
        }
        bfw.flush();
    }


}
