import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no1863 {
    /**
     * 첫째 줄에 n이 주어진다.
     * (1 ≤ n ≤ 50,000)
     * 다음 n개의 줄에는 왼쪽부터 스카이라인을 보아 갈 때 스카이라인의 고도가 바뀌는 지점의 좌표 x와 y가 주어진다.
     * (1 ≤ x ≤ 1,000,000. 0 ≤ y ≤ 500,000)
     * 첫 번째 지점의 x좌표는 항상 1이다.
     * <p>
     * 고도 높아지면 푸쉬 낮아지면 팝 스택 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));


        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int n = Integer.parseInt(bfr.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() > y) { // 스택이 비어있지 않고 y가 작으면
                stack.pop();
                count++;
            }
            if (!stack.isEmpty() && stack.peek() == y) continue;

            stack.push(y);

        }
        while (!stack.isEmpty()) {
            if(stack.pop()!=0) count++;
            //예제 스택 잔여 요소 0,1 size 2
            // 0 은 제외해야함!!!!
        }

        bfw.write(count + "");
        bfw.flush();

    }
}
