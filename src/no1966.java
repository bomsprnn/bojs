
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1966 { //16564	192
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bfr.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); // 입력


            st = new StringTokenizer(bfr.readLine());

            Queue<Integer> prior = new LinkedList<>(); // 중요도
            Queue<Integer> seq = new LinkedList<>(); // 순서

            for (int j = 0; j < n; j++) {
                seq.add(j); //순서 큐
                prior.add(Integer.parseInt(st.nextToken())); //중요도 큐
            }

            int count = 0;
            while (!seq.isEmpty()) {
                int max = Collections.max(prior); //최대값(중요도)
                int current = prior.poll(); //현재 중요도
                int currentIndex = seq.poll(); //현재 순서

                if (current == max) { //프린트
                    count++;

                    if (currentIndex == m) { //같으면서 순서도 같으면
                        bfw.write(count + "\n");
                        break;
                    }
                } else { //맨 뒤로 넣기
                    prior.add(current);
                    seq.add(currentIndex);
                }
            }
        }
        bfw.flush();
    }
}