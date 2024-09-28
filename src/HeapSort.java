public class HeapSort {
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i=0; i<arr.length;i++){ // O(N)
            heapInsert(arr,i); // O(logN)
        }
        int heapsize = arr.length;
        // 0位置上的数最大，与最后一个数做交换，然后从0位置开始向下移动，使数组变为大根堆
        swap(arr, 0, --heapsize);
        while(heapsize > 0){ // O(N)
            heapify(arr, 0, heapsize); // O(logN)
            swap(arr, 0, --heapsize); // O(1)
        }
    }
    // 插入一个数，从下往上移动，使数组变为大根堆
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }
    // 从index位置开始向下移动，使数组变为大根堆
    public static void heapify(int[] arr, int index, int heapsize){
        int left = index*2+1;
        while(left < heapsize){
            int largest = left+1 < heapsize && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index*2+1;
        }
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}