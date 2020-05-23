import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        for (int i = 0; i < in.length - 1; i++) {
            if (in[i].compareTo(in[i + 1]) > 0) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}