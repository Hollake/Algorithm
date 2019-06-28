package arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hollake on 2019\6\28 0028 17:33.
 */
public class MergeOrderArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 7, 30, 40, 50};
        int[] arr2 = {2, 2, 3, 4, 5, 6, 6, 6, 7, 7};
        int[] arr3 = {12, 15, 16};
        int[] arr4 = {1, 3, 8};
        List<int[]> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        int i = 1;
        int[] temp = list.get(0);
        while ( i < list.size() ) {//多个有序数组合并我就只想到循环依次进行合并
            temp = merge(temp, list.get(i));
            i++;
        }
        System.out.println(Arrays.toString(temp));
    }
//  合并两个有序数组
    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] res = new int[arr1.length + arr2.length];
        while ( i < arr1.length && j < arr2.length ) {
            res[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }
        while ( i < arr1.length ) {
            res[k++] = arr1[i++];
        }
        while ( j < arr2.length ) {
            res[k++] = arr1[j++];
        }
        return res;
    }
}
