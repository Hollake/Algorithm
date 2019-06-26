package arithmetic;

import java.util.Arrays;

/**
 * 题目描述
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Soluton13 {
    public static void main(String[] args) {
//        int[] array = reduceArr(8);
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(array));
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
    public static void reOrderArray(int [] array) {
        if ( array == null || array.length == 0 ) return;
        int left = 0;//从左向右最右边的奇数下标
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int cur = i;//碰到的奇数
                while ( cur > left ) {//逐个交换已经排序了的最右边的奇数下标到当前奇数之间的所有数
                    swap(array, cur, --cur);
                }
                left++;//交换完奇数下标向右移动
            }
        }
    }
    private static void swap(int[] array, int j, int i) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int[] reduceArr(int num) {
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = (int) (Math.random() * num);
        }
        return res;
    }
}
