import java.util.PriorityQueue;

public class SortArrayDistanceLessK {
    public static void sortArrayDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(; index<=Math.min(arr.length, k); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for(; index<arr.length; i++, index++){
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }
        while(!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,6,3,12,56,8};
        sortArrayDistanceLessK(arr, 3);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
