import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][n];

        // fill in matrix
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j< m[i].length; j++) {
                if (i == j) { m[i][j] = 0; }
                else if (i > j) { m[i][j] = i - j; }
                else if (i < j) { m[i][j] = j - i; }
            }
        }

        // build output and display
        StringBuilder sb = new StringBuilder();
        for (int[] row : m) {
            for (int number : row) {
                sb.append(number + " ");
            }
            // remove last blank space and add line break
            sb.replace(sb.length() - 1, sb.length(), "\n");
        }
        System.out.println(sb.toString());

    }
}