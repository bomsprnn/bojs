import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class no2295 {//63432	400ms
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());

        /**
         *  N(5 ≤ N ≤ 1,000)개의 자연수들로 이루어진 집합 U가 있다.
         *  이 중에서 적당히 세 수를 골랐을 때, 그 세 수의 합 d도 U안에 포함되는 경우
         *  그 합이 가장 큰 경우를 찾기
         */

        /*  접근
         * 1. 3중for문 --> 시간초과..당연함
         * 2. for문 2개로 나누기 1. 작은 두 수 합 for문  2. 큰 수 for문 (가장큰수-다음큰수) x+y / +z=k; 분리
         */

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bfr.readLine());
        } // 배열로 입력받기

        Set<Integer> set = new HashSet<>(); //어차피 작은 두 수를 더한 값은 중복되어도 상관없기 때문에 셋 사용
        for (int i = 0; i < n; i++) {
            for (int j = i ; j < n; j++) { //중복 선택을 방지하기 위해 j=i부터 시작
                set.add(arr[i] + arr[j]);
            }
        } //작은 두 수를 더한 모든 값 셋에 넣기

        int max = 0; //가장 큰 수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(arr[i] - arr[j])) { //만약 셋에 k-z가 있다면
                    max = Math.max(max, arr[i]); //가장 큰 수 갱신
                }
            }
        } //큰 수 찾기

        bfw.write(max + "");
        bfw.flush();
    }
}
