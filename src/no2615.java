import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class no2615 {

    public static int check(int[][] grid, int x, int y) {
        boolean ans = true;
        int target = grid[x][y]; //현재 위치

        for (int i = 1; i < 5; i++) {
            if (y + i > 18 && grid[x][y + i] != target) {
                ans = false;
            }
        }
        if (y - 1 > -1 && grid[x][y - 1] == target) {
            ans = false;
        }
        if (y + 5 < 19 && grid[x][y + 5] == target) {
            ans = false;
        }
        if (ans) return 1;

        // case 2 |
        ans = true;
        for (int i = 1; i < 5; i++) {
            if (x + i > 18 || grid[x + i][y] != target) {
                ans = false;
                break;
            }
        }
        if (x - 1 > -1 && grid[x - 1][y] == target) {
            ans = false;
        }
        if (x + 5 < 19 && grid[x + 5][y] == target) {
            ans = false;
        }
//		System.out.println("2");
        if (ans) return 2;

        // case 3 /
        ans = true;
        for (int i = 1; i < 5; i++) {
            if (x + i > 18 || y - i < 0 || grid[x + i][y - i] != target) {
                ans = false;
                break;
            }
        }
        if (x - 1 > -1 && y + 1 < 19 && grid[x - 1][y + 1] == target) {
            ans = false;
        }
        if (x + 5 < 19 && y - 5 > -1 && grid[x + 5][y - 5] == target) {
            ans = false;
        }
//		System.out.println("3");
        if (ans) return 3;

        // case 4 \
        ans = true;
        for (int i = 1; i < 5; i++) {
            if (x + i > 18 || y + i > 18 || grid[x + i][y + i] != target) {
                ans = false;
                break;
            }
        }
        if (x - 1 > -1 && y - 1 > -1 && grid[x - 1][y - 1] == target) {
            ans = false;
        }
        if (x + 5 < 19 && y + 5 < 19 && grid[x + 5][y + 5] == target) {
            ans = false;
        }
//		System.out.println("4");
        if (ans) return 4;

        return 5;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] grid = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < 19; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int backcase = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (grid[i][j] != 0) {
                    backcase = check(grid, i, j);
                    if (backcase == 1 || backcase == 2 || backcase == 4) {
                        System.out.println(grid[i][j]);
                        System.out.printf("%d %d", i + 1, j + 1);
                        System.exit(0);
                    } else if (backcase == 3) {
                        System.out.println(grid[i][j]);
                        System.out.printf("%d %d", i + 5, j - 3);
                        System.exit(0);
                    }

                }
            }
        }

        System.out.println(0);
    }

}