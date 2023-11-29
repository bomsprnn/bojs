import java.io.*;
import java.util.StringTokenizer;

public class no24060 {

    public static int[] src;
    public static int[] tmp; //병합할 때 사용하는 임시 배열이다.
    public static int[] order;
    public static int orderidx =0;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken()); //count of test case
        int k = Integer.parseInt(st.nextToken()); //limit
        src = new int[n];
        StringTokenizer st2 = new StringTokenizer(bfr.readLine());
        for(int i=0;i<n;i++){
            src[i]= Integer.parseInt(st2.nextToken());
        }
        tmp = new int[src.length];
        printArray(src);
        mergeSort(0, src.length-1);
        printArray(src);
        order = new int[n];
        System.out.print(order[k]+" ");

    }

    public static void mergeSort(int start, int end) {
        if (start<end) { //배열의 길이가 2 이상일 때 분할한다.
            int mid = (start+end) / 2; //분할을 위해 중앙의 값을 선정한다.
            mergeSort(start, mid); //분할 후 왼쪽의 배열로, 재귀호출을 통해 배열의 길이가 1일 때 까지 나눈다.
            mergeSort(mid+1, end); //분할 후 오른쪽의 배열

            int p = start; //왼쪽 배열의 첫번째 값
            int q = mid + 1; //오른쪽 배열의 첫번째 값
            int idx = p; //결과 배열의 인덱스

            while (p<=mid || q<=end) { //첫번째 배열이나 두번째 배열이 끝날 때 까지 반복한다.
                if (q>end || (p<=mid && src[p]<src[q])) {
                    //오른쪽 배열이 끝난다면, 왼쪽 배열은 이미 정렬된 상태이므로 그대로 복사.
                    //왼쪽 배열의 첫번째 값이 오른쪽 배열의 값보다 작으면 왼쪽 배열의 처음 값을 임시 배열에 저장 후, 다음 값 비교를 위해 첫번째 값의 인덱스를 수정
                    tmp[idx++] = src[p++];
                    order[orderidx++]=p;
                } else {
                    tmp[idx++] = src[q++];
                    order[orderidx++]=q;

                }
            }

            for (int i=start;i<=end;i++) {
                src[i]=tmp[i]; //완성된 배열을 원 배열에 복사한다.
            }
        }
    }

    public static void printArray(int[] a) {
        for (int i=0;i<a.length;i++)

            System.out.print(a[i]+" ");

        System.out.println();
    }
}
