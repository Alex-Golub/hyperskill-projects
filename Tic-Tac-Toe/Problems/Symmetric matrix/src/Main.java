import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        boolean isSymmetric = true;
        for (int i = 0; i < m.length && isSymmetric; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != m[j][i]) {
                    isSymmetric = false;
                    break;
                }
            }
        }
        System.out.println(isSymmetric ? "YES" : "NO");
    }
}