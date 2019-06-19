package class_3;

/**
 * Created by Hollake on 2019\6\19 0019 15:39.
 */
public class MoreHalfNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 3, 3, 3, 3};
        System.out.println(MoreHalfNum.moreHalfNum(arr));
    }
    public static int moreHalfNum(int[] arr) {
        if (arr == null || arr.length < 1) return 0;
        int current = arr[0];//当前位置元素
        int flag = 1;//初始值1
        for (int i = 1; i < arr.length; i++) {
            if (flag > 0) {
                if (current == arr[i]) flag++;//遇到相等的元素flag就++
                else flag--;//否则就抵消
            } else {
                current = arr[i];//当flag为0的时候，current重新设定为当前遍历到的值
                flag = 1;
            }
        }
        //如果这个数是存在的，那么其实直接返回current就行
        if (flag>=arr.length/2){
            return current;//最后current中存储的就是出现次数超过⌊n/2⌋的数字
        }
        return 0;
        
    }
}
