import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class no2346ver2 { //16928	208

    public static void main(String[] args) throws IOException {
        /**
         * 원형으로 놓인 풍선
         * 풍선에는 숫자가 적혀있는데, 이는 풍선을 터뜨린 후 이동하는 경로
         * 터뜨린 풍선은 제외
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine()); //풍선 개수
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        Deque<balloon> deque = new ArrayDeque<>(); //풍선 덱
        for (int i = 0; i < n; i++) {
            balloon b = new balloon(i + 1, Integer.parseInt(st.nextToken()));
            //풍선 객체 생성
            deque.add(b);
        } //풍선 저장
        // 3 -2 3 4 1   일 경우 덱
        while (!deque.isEmpty()) {
            balloon a = deque.pollFirst();
            bfw.write(a.index + " ");
            if (deque.isEmpty()) break; // 더 이상 풍선 없으면 중단

            if (a.move < 0) { //풍선에 적힌 숫자가 음수일 경우
                for (int i = 0; i < Math.abs(a.move); i++) {//풍선에 적힌 수의 절대값만큼 반복
                    deque.addFirst(deque.pollLast());
                }
            } else if (a.move > 0) { //풍선에 적힌 숫자가 양수일 경우
                for (int i = 1; i < a.move; i++) { //풍선에 적힌 수만큼 반복
                    deque.addLast(deque.pollFirst());
                }
            }
        }
        bfw.flush();


    }

    static class balloon {
        int index = 0;
        int move = 0;

        balloon(int a, int b) {
            index = a;
            move = b;
        }
    }
}