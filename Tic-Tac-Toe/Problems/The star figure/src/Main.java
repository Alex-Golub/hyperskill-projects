import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r == c || r + c == n - 1 || c == n / 2 || r == n / 2) {
                    sb.append("* ");
                } else {
                    sb.append(". ");
                }
            }
            System.out.println(sb.toString().trim());
            sb.delete(0, sb.length());
        }
    }
}