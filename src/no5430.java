import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class no5430 {
    public static void main(String[] args) throws IOException {
        /**
         * 함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고,
         * D는 첫 번째 수를 버리는 함수이다.
         * 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
         */

        /* 영준님 코멘트 *******8
         * D명령이 끝나고 배열이 비었을때 빈 배열을 반환하는 로직이 부족한 것 같았어요.
         * 다음과 같은 케이스를 예로 들어 볼게요!
         * 예)
         * 1
         * D
         * 1
         * [1]
         * 1개의 테스트 케이스에 대해서, D command 사용, 배열의 length = 1, 배열 = [1]
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < t; i++) {
            String p = bfr.readLine();
            int n = Integer.parseInt(bfr.readLine());
            String arr = bfr.readLine().replace("[", "").replace("]", "");
            String[] originArr = arr.split(","); //배열 저장
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(originArr[j]));
            } //덱에 배열 저장


            boolean isReverse = false;
            //덱을 복사하면서 뒤집으니까 에러 발생.
            boolean isError = false; //에러 발생 여부


            for (int j = 0; j < p.length(); j++) { //수행 횟수만큼 반복
                if (p.charAt(j) == 'R') { //배열 뒤집기 R 수행
                    isReverse = !isReverse;
                } else { //첫번째 수 버리기 D 수행
                    if (deque.isEmpty()) { //덱이 비어있으면 에러
                        isError = true;
                        bfw.write("error\n");
                        break;
                    } else if (isReverse) deque.pollLast(); //뒤집어져 있으면 뒤에서 poll
                    else deque.pollFirst(); //아니면 앞에서 poll
                }
            }

            if (!isError) { //덱이 비어있지 않으면 출력 --> 에러가 발생하지 않았다면 출력(빈 배열 처리)
                bfw.write("[");
                if (deque.isEmpty()) {
                    bfw.write("]\n");
                    continue;
                } //덱이 비어있으면 빈 배열 출력!!
                if (isReverse) {
                    while (deque.size() > 1) {
                        bfw.write(deque.pollLast() + ",");
                    }
                    bfw.write(deque.pollLast() + "]\n");
                } else {
                    while (deque.size() > 1) {
                        bfw.write(deque.pollFirst() + ",");
                    }
                    bfw.write(deque.pollFirst() + "]\n");
                }

            }

        }
        bfw.flush();
    }
}
