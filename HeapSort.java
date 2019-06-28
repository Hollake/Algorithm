package sort;

import java.util.Arrays;

/**
 * Created by Hollake on 2019\5\30 0030.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 9, 3, 6, 4, 86, 3, 2, 4};
//        int[] arr = reduceArr(10);//产生随机数组进行测试
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //    堆排时间复杂度O(N*logN)，额外空间复杂度O(1)，不稳定
    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//      从第一个数开始遍历，让数组变为大根堆（大根堆是完全二叉树）
        for (int i = 0; i < arr.length; i++) {
//            每次堆的容量扩大1，插入一个数就进行顺序调整，保证最大的数一直在堆顶
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        while ( heapSize > 0 ) {
//          将大根堆第一个数也就是数组第一个数（大根堆中最大的数）和大根堆最后一个数交换位置，然后大根堆大小减一
            swap(arr, 0, --heapSize);
//          让交换到0位置相对较小的数下沉，继续调整顺序形成大根堆。
            heapify(arr, 0, heapSize);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
//        大根堆父节点的左叶子结点
        int left = index * 2 + 1;
//        判断左儿子是否越界
        while ( left < heapSize ) {
//            判断父节点的左儿子在没有越界的情况下谁最大，largest现在表示index两个子节点的最大值下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
//            接着继续判断当前节点index与两个子节点中的最大值下标largest谁最大，继续赋值给largest
            largest = arr[index] > arr[largest] ? index : largest;
//            当最大值下标就是本身的时候直接退出循环
            if (largest == index) {
                break;
            }
//            交换父节点和左右儿子中的最大值
            swap(arr, largest, index);
//            将左右儿子最大值下标赋给父节点
            index = largest;
//            赋值后父节点的左儿子
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
//        当index位置的这个值大于它的父节点的时候需要上浮，最终形成大根堆
        while ( arr[index] > arr[(index - 1) / 2] ) {
//            如果大于交换位置
            swap(arr, index, (index - 1) / 2);
//            更新节点，把父节点更新为当前节点，继续循环
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static int[] reduceArr(int num) {
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = (int) (Math.random() * num);
        }
        return res;
    }
}
