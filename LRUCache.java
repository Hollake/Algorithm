package test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Hollake on 2019\6\21 0021 10:36.
 */
public class LRUCache<K,V> extends LinkedHashMap {
    private  int cacheSize;
    LRUCache(int cacheSize) {
        super(cacheSize, 0.75f, true);//继承父类构造器，将accessOrder设置为true
        this.cacheSize = cacheSize;
    }
//    重写此方法，在大于cacheSize的时候插入时会删除最不常使用的那个元素
//    在查找的时候，如果元素存在在队列中，那么返回值，如果没有则返回null
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > cacheSize;
    }
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.put(12, "32");
        System.out.println(cache.get(1));
        cache.put(32, "324c");
        cache.get(1);
        cache.get(12);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }
}
