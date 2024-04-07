import java.io.*;
import java.util.Arrays;

public class no3649 { //312832	1816ms

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        /**
         * 조건
         * 구멍 넓이 x, 하나의 구멍은 두 조각의 레고로 막는다.
         * 구멍의 넓이 x, 레고 조각의 수 n, 레고 조각의 길이 l
         *
         * 접근
         * 단위에 주의해야 할 것 같다.
         * 정답이 여러 개인 경우 |ℓ1 - ℓ2|가 가장 큰 것을 출력 -> 인덱스를 양쪽 끝에서부터 모으면 충족할듯?
         * 구멍의 단위 cm, 레고 조각의 단위 nm -> 1cm = 10^7nm로 변환해서 계산
         * 레고 조각의 길이를 배열에 저장하고, 인덱스를 양 끝에 지정해서 합이 x와 같은지 확인
         * -> 시간초과... 걱정되지만 일단 해보기---> 어어 ㅇㅣ게되누...
         *
         */
        String first;
        while ((first = bfr.readLine())!=null) {
            int x = Integer.parseInt((first)); // 구멍 넓이
            x = x * 10_000_000; //단위 변환
            int n = Integer.parseInt(bfr.readLine()); // 레고 조각의 수
            int[] lego = new int[n];
            for (int i = 0; i < n; i++) {
                lego[i] = Integer.parseInt((bfr.readLine())); // 단위 변환
            }

            int left = 0;
            int right = n - 1;
            Arrays.sort(lego); //인덱스 설정을 위해 정렬
            boolean flag = false;
            while (left < right) {
                if (lego[left] + lego[right] == x) { // 만약 합이 x와 같다면
                    bfw.write("yes " + lego[left] + " " + lego[right]+ "\n");
                    flag = true;
                    break;
                } else if (lego[left] + lego[right] < x) { //합이 x보다 작다면
                    left++; //왼쪽 인덱스 증가
                } else {
                    right--; //합이 x보다 크다면 오른쪽 인덱스 감소
                }
            }
            if(!flag){ //flag가 false면
                bfw.write("danger"+ "\n");
            }

        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
}
