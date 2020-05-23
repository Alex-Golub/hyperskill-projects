import java.util.Scanner;

class Main {

  static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int size = sc.nextInt();
    int[] arr = getArray(size);
    int result = findFirstMaxIndex(arr, size);
    System.out.println(result);
  }

  private static int findFirstMaxIndex(int[] arr, int size) {
    if (size < 1) { return -1; }
    int maxValue = arr[0];
    int maxIndex = 0;
    for (int i = 1; i < size; ++i) {
        if (arr[i] > maxValue) {
            maxValue = arr[i];
            maxIndex = i;
        }
    }
    return maxIndex;
  }

  private static int[] getArray(int size) {
    if (size < 1) { return new int[0]; }
    int[] out = new int[size];
    for (int i = 0; i < size; ++i) {
      out[i] = sc.nextInt();
    }
    return out;
  }


}