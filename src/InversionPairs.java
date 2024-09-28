public class InversionPairs { 
    private static long inversionCount = 0; // 用于计数逆序对的数量

    public static void main(String[] args) {
        int[] num = {8, 7, 4, 3, 2};
        inversionPairs(num);
        System.out.println("Total inversion count: " + inversionCount);
    }
    public static void inversionPairs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergesort(arr, 0, arr.length - 1);
    }
    public static void mergesort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergesort(arr, l, mid);
            mergesort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = mid + 1, i = 0;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
                inversionCount += (mid - p1 + 1); // 计算逆序对的数量
                for (int j = p1; j <= mid; j++) {
                    System.out.println("(" + arr[j] + ", " + arr[p2 - 1] + ")");
                }
            }
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, l, help.length);
    }
}