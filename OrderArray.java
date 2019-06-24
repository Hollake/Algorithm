package arithmetic;

import java.util.Arrays;

/**
 * Created by Hollake on 2019\6\24 0024 21:49.
 */
public class OrderArray {
    public static void main(String[] args) {
        int[] arr ={13,3,2,6,4,1,7,8,5,10};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void reOrderArray(int[] arr) {
        if (arr.length == 0 || arr == null) return;
        int less = 0;
        int more = arr.length - 1;
        while ( less < more ) {
                while ( arr[less] % 2 == 0 ) {//只要当前less位置的元素为偶数
                    swap(arr, less, more);//交换位置
                    more--;//交换后more位置肯定为偶数了，那么more--，继续循环判断交换的元素是否是偶数
                }
            less++;
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
