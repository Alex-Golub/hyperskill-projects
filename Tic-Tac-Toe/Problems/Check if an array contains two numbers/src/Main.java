import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        // get index of required numbers
        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == n1) { i1 = i; continue; }
            if (arr[i] == n2) { i2 = i; continue; }
        }

        // check distance between indexes
        String res = i1 == - 1 || i2 == -1 ? "false" :
                Math.abs(i1 - i2) == 1 ? "true" : "false";
        System.out.println(res);


    }
}