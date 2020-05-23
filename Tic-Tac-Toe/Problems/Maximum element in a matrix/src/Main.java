import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int maxValue = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;
        int[][] mat = new int[n][m];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
                if (mat[i][j] > maxValue) {
                    maxRow = i;
                    maxCol = j;
                    maxValue = mat[i][j];
                }
            }
        }
        System.out.println(maxRow + " " + maxCol);
    }
}