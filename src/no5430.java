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

            for (int j = 0; j < p.length(); j++) { //수행 횟수만큼 반복
                if (p.charAt(j) == 'R') { //배열 뒤집기 R 수행
                    isReverse = !isReverse;
                    }
                else { //첫번째 수 버리기 D 수행
                    if (deque.isEmpty()) { //덱이 비어있으면 에러
                        bfw.write("error\n");
                        break;
                    }
                    else if(isReverse) deque.pollLast(); //뒤집어져 있으면 뒤에서 poll
                    else deque.pollFirst(); //아니면 앞에서 poll
                }
            }


            if(!deque.isEmpty()){
                bfw.write("[");
                while (!deque.isEmpty()) {
                    if (isReverse) {
                        bfw.write(deque.pollLast() + (!deque.isEmpty() ? "," : ""));
                    } else {
                        bfw.write(deque.pollFirst() + (!deque.isEmpty() ? "," : ""));
                    }
                }
                bfw.write("]\n");
            }
        }bfw.flush();
    }
}
