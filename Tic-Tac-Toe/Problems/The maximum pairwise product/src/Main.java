import java.util.Scanner;

class Main {

    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = getArray();
        int result = findMaxProductPair(arr);
        System.out.println(result);

    }

    private static int findMaxProductPair(int[] arr) {
        if (arr.length < 2) { return arr[0]; }
        int maxProduct = arr[0] * arr[1];
        for (int i = 1; i < arr.length - 1; ++i) {
            int currProduct = arr[i] * arr[i + 1];
            if (currProduct > maxProduct) {
                maxProduct = currProduct;
            }
        }
        return maxProduct;
    }

    private static int[] getArray() {
        int size = sc.nextInt();
        int[] out = new int[size];
        for (int i = 0; i < size; ++i) {
            out[i] = sc.nextInt();
        }
        return out;
    }
}