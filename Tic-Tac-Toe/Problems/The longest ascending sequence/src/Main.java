import java.util.Scanner;

class Main {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = getArray();
        int result = maxAscSeq(arr);
        System.out.println(result);
    }

    private static int maxAscSeq(int[] arr) {
        int maxSeqCnt = 1;
        for (int i = 0, j = i; i < arr.length; i = j, ++j) {
            int currentSeqCnt = 1;
            for (; j < arr.length - 1; ++j) {
                if (arr[j + 1] > arr[j]) {
                    ++currentSeqCnt;
                } else {
                    break;
                }
            }
            if (currentSeqCnt > maxSeqCnt) {
                maxSeqCnt = currentSeqCnt;
            }
        }
        return maxSeqCnt;
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