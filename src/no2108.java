import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class no2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        /**
         * 조건
         * 입력받은 n개의 수에 대한
         * 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값 - 소수점 이하 첫째 자리에서 반올림
         * 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
         * 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
         * 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
         * 를 출력
         *
         * 접근
         * 1. 산술평균 : 입력과 동시에 합 구해서 마지막에 나누기
         * 4. 범위 : 최댓값-최솟값 입력과 동시에 비교해서 갱신
         * 이 두 연산은 반복문 안에서 수행하기
         * 2. 중앙값 : 입력받은 수를 정렬하고 중앙값 출력
         * 3. 최빈값 : 입력받은 수를 정렬하고 맵에 횟수 저장
         *
         */
        int n = Integer.parseInt(bfr.readLine());
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bfr.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr); //정렬

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) map.replace(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1); //등장 횟수와 함께 저장
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        //맵으로는.. value값으로 정렬 할 수 없어서 리스트로 변환
        Collections.sort(list, (e1, e2) -> e1.getValue() == e2.getValue() ? e1.getKey() - e2.getKey() : e2.getValue() - e1.getValue());
        //value값으로 정렬, value값이 같다면 key값으로 정렬

        bfw.write(Math.round(Arrays.stream(arr).average().orElse(0)) + "\n"); //산술평균
        bfw.write(arr[n/2]+"\n"); //중앙값
        if(n == 1) bfw.write(list.get(0).getKey()+"\n"); //최빈값
        else bfw.write((list.get(0).getValue() == list.get(1).getValue() ? list.get(1).getKey() : list.get(0).getKey())+"\n");
        bfw.write(Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt()+"\n"); //최대값 최소값 차이
        bfw.flush();
    }

}
