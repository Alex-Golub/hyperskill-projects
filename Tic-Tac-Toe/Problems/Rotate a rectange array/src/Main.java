import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[m][n];
        // start inserting the scanned values
        // to the last column process till get to column 0
        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < m; row++) {
                mat[row][col] = sc.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : mat) {
            for (int val : row) {
                sb.append(val + " ");
            }
            sb.replace(sb.length() - 1, sb.length(), "\n");
        }
        System.out.println(sb.toString());
    }
}