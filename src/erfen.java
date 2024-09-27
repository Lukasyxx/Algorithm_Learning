public class erfen {
    public static int findLocalMinimum(int[] arr){
        if (arr == null || arr.length<2){
            return 0;
        }
        //第一个元素如果比第二个要小，因为左边没有数，所以第一个元素就是一个局部最小数。
        if (arr[0] < arr[1]){
            return arr[0];
        }
        //数组最后一个元素如果比倒数第二个元素值要小，说明最后一个元素也是一个局部最小数。
        if (arr[arr.length-1] < arr[arr.length-2]){
            return arr[arr.length-1];
        }
         //中间进行二分。利用数据特性。如果前面两个条件都不满足,说明在第一个和倒数第一个中间一定存在局部最小值。
        int begin = 1;
        int end = arr.length-2;
        int mid = (begin + end)/2;
        while (begin < end){
            if (arr[mid] > arr[mid-1]){
                end = mid-1;
            }else if (arr[mid] > arr[mid+1]){
                begin=mid+1;
            }else {
                return mid;
            }
            mid = (begin +end)/2;
        }
        return begin;
    }
}

