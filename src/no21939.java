import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         *  조건
         *  센티가 뿅망치로 거인을 패면 거인의 키가 1/2로 줄어든다.
         *  이미 키가 1인 경우에는 더 줄어들지 않는다.
         *  가장 큰 거인을 골라 패는 전략을 k번 수행한다.
         *  모든 거인의 키를 센티의 키보다 줄인 경우 yes + 뿅망치 최소 사용 횟수 출력
         *  아닌 경우 no + 가장 큰 거인의 키 출력
         *
         *  거인의 수 n(1 ≤ n ≤ 10^5)
         *  센티의 키 x(1 ≤ x ≤ 2 × 10^9)
         *  딜 횟수 t(1 ≤ t ≤ 10^5)
         *
         * 접근
         * 큰 거인부터 골라 패야하기 때문에 우선순위 큐에 때려넣고 순서대로 공격
         */
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); //max heap

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(bfr.readLine())); //pq에 거인 키 저장
        }

        int cnt = 0; //뿅망치 사용 횟수
        for (int i = 0; i < t; i++) {
            int first = pq.peek(); //가장 큰 거인 체크
            if (first <= 1 || first < x) break; //가장 큰 거인이 1보다 작으면 break;
            cnt++; //뿅망치 사용 횟수 증가
            pq.poll(); //가장 큰 거인 제거
            pq.add(first / 2); //키가 센티보다 크면 반타작
        }
        if (pq.peek() < x) bfw.write("YES\n" + cnt);
        else bfw.write("NO\n" + pq.peek()); //가장 큰 거인의 키
        bfw.flush();

    }
}
