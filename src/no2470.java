import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2470 {// 28428	392ms
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());

        /**
         * 산: 1부터 1,000,000,000양의 정수, 알칼리: -1부터 -1,000,000,000까지의 음의 정수
         * 혼합한 용액의 특성값은 각 용액의 특성값 합!! "0에 가장 가까운"  혼합용액 맨들기
         *
         * 접근
         * 일단 ... 0에 가까우려면 절대값의 크기가 비슷해야하는데
         * 일단 가장 수행을 적게 하려면 배열 정렬하고 양쪽 끝에서부터.. 인덱스 줄이면서 탐색해보기
         *
         */

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //용액 배열에 추가
        Arrays.sort(arr); //정렬
        int idx1 = 0; //왼쪽 인덱스(작은 값)
        int idx2 = n - 1; //오른쪽 인덱스(큰 값)

        long min = Math.abs(arr[0]+arr[n-1]); //합의 최소값, 0에 가까워야합니다
        int alkali = 0; //첫번쨰 용액(알칼리)
        int acid = 0; //두번째 용액(산)
        while (idx1 < idx2) {
            long sum = arr[idx1] + arr[idx2]; //인덱스가 가리키는 배열의 요소 합
            if (Math.abs(sum) <= min) { //합이 음수일 경우를 대비해 절대값처리, 만약 이것이 지금까지 구한 최소값보다 작다면
                min = Math.abs(sum); //최소값 갱신
                alkali = arr[idx1]; //알칼리 갱신
                acid = arr[idx2]; //산 갱신
            }
            if (sum < 0) { //합이 음수라면--> 0에 가까우려면 음수의 절대값이 작아져야함
                idx1++; //왼쪽 인덱스 증가
            } else if (sum > 0){ //합이 양수라면 --> 0에 가까우려면 양수의 절대값이 작아져야함
                idx2--; //합이 양수라면 --> 0에 가까우려면 양수의 절대값이 작아져야함
            }else break; //합이 0
        }
        bfw.write(alkali + " " + acid);
        bfw.flush();
    }
}
