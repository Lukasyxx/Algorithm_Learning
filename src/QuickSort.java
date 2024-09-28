public class QuickSort {
    public static void quickSort(int[] arr) {
        if(arr==null || arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);
    }
    public static void process(int[] arr,int l,int r){
        if(l<r){
            swap(arr, l+(int)(Math.random()*(r-l+1)), r);
            int[] p = partition(arr, l, r);
            process(arr, l, p[0]-1); // <区域
            process(arr, p[1]+1, r); // >区域
        }
    }
    // 默认以arr[r]做划分
    // 函数返回等于区域的左边界和右边界
    public static int[] partition(int[] arr,int l,int r){
        int less = l-1; // <区域右边界
        int more = r; // >区域左边界
        while(l<more){
            if(arr[l]<arr[r]){
                swap(arr, ++less, l++); // 当前位置和<区域下一个交换，less右扩，l右移
            }
            else if(arr[l]>arr[r]){
                swap(arr, --more, l); // 当前位置和>区域前一个交换，more左扩，l不变
            }
            else{
                l++; // 当前位置和划分值相等，不交换，l直接右移
            }
        }
        swap(arr, more, r); // 用来做划分的数 最后放到>区域的第一个位置
        return new int[]{less+1, more};
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
