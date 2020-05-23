import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        // get array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // get columns to swap and do swap
        int col1 = sc.nextInt();
        int col2 = sc.nextInt();
        for (int i = 0; i < rows; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }

        // build and print result array
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int number : row) {
                sb.append(number + " ");
            }
            sb.replace(sb.length() - 1, sb.length(), "\n");
        }

        System.out.println(sb.toString());

    }


}