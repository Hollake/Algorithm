package arithmetic;

import java.util.*;

/**
 * Created by Hollake on 2019\6\26 0026 15:42.
 */
public class ZX {
    public static void main(String[] args) {
//        int[] salaries = {20,40,26,25,40,20,40,20,40,25};
        int[] salaries = reduceArr(10); //有兴趣可以用这个方法产生随机数组进行测试
        System.out.println(Arrays.toString(salaries));
        List<Integer> list = reOrder(10,salaries);
        System.out.println(list.toString());
    }

    public static List<Integer> reOrder(int num ,int[] salaries) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();//保证在接下来取元素的时候的有序性
        if (salaries == null || salaries.length == 0) return list;
//        Arrays.sort(salaries);//自己手贱加了这句。导致出了错误，相同元素的按照大小顺序排序
        for (int i = 0; i < salaries.length; i++) {
            if (!map.containsKey(salaries[i])) {
                map.put(salaries[i], 1);
            }else{
                map.put(salaries[i], map.get(salaries[i]) + 1);
            }
        }
        List<Integer> help = new ArrayList<>();//不同元素的辅助list
        List<Integer> count = new ArrayList<>();//不同元素所对应个数的list

        for (Integer key : map.keySet()) {
            help.add(key);//添加元素
            count.add(map.get(key));//添加对应元素的频率
        }
        int len = count.size();
        for (int i = 0; i < len; i++) {
            int max = 0;//对应频率最大值
            int index = 0;//频率最大值处所对应的下标
            for (int j = 0; j < count.size(); j++) {
                if (max < count.get(j)) {
                    max = count.get(j);//找到最大频率
                    index = j;//扎到最大频率所对应元素下标
                }
            }
            for (int j = 0; j < max; j++) {
                list.add(help.get(index));//添加max个index位置所对应的元素
            }
//            添加后删除index位置所对应的元素和频率。
            help.remove(index);
            count.remove(index);
        }
        return list;
    }

    public static int[] reduceArr(int num) {
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = (int) (Math.random() * num);
        }
        return res;
    }
}
