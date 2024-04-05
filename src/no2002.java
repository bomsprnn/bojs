import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class no2002 { //14388	136ms
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<String> in = new LinkedList<>();
        int n = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < n; i++) {
            in.add(bfr.readLine());
        } //들어오는 차량을 큐에 넣기

        int cnt = 0; //추월 차량 수
        while (!in.isEmpty()) { //나가는 차량을 하나씩 비교
            String o = bfr.readLine();
            if (in.peek().equals(o)) in.poll();
            //들어오는 차량과 나가는 차량이 같으면 큐에서 제거
            else {
                in.remove(o);
                cnt++; //다르면 추월 차량 수 증가
            }
        }

        bfw.write(cnt + "");
        bfw.flush();
    }
}
