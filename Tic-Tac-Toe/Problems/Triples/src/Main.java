import java.util.Scanner;

class Main {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = getArray();
        int result = countTriples(arr, arr.length);
        System.out.println(result);
    }

    private static int countTriples(int[] arr, int len) {
        int counter = 0;
        for (int i = 0; i < len - 2; ++i) {
            int n1 = arr[i];
            int n2 = arr[i + 1];
            int n3 = arr[i + 2];
            if (n3 - n2 == 1 && n2 - n1 == 1) {
                counter++;
            }
        }
        return counter;
    }

    private static int[] getArray() {
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}