import java.util.Scanner;

class Main {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = getArray();
        int rotations = sc.nextInt();
        rotateArray(arr, arr.length, rotations);
    }

    private static void rotateArray(int[] arr, int len, int r) {
        StringBuilder rotated = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            rotated.append(arr[ (len - (r % len) + i) % len ] + " ");
        }
        System.out.println(rotated.toString().trim());
    }

    private static int[] getArray() {
        String[] in = sc.nextLine().split("\\s+");
        int[] arr = new int[in.length];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = Integer.parseInt(in[i]);
        }
        return arr;

    }
}