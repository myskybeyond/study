package xyz.lijiantao.study.mianshi.bloomfilter;

import java.util.BitSet;

/**
 * 布隆过滤器
 *
 * @author Jiantao Li
 * @date 2020/2/12 9:59
 */
public class MyBloomFilter {

    /**
     * 位数组大小
     */
    public final static int DEFAULT_SIZE = 2 << 24;

    /**
     * 通过这个数组可以创建6个不同的哈希函数
     */
    private final static int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

    /**
     * 位数组。数组中的元素只能是0或1
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    /**
     * 存放包含hash函数的类的数组
     */
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    /**
     * 初始化多个包含hash函数的类的数组，每个类中的hash函数都不一样
     */
    public MyBloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * 添加元素到位数组
     */
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }


    /**
     * 判断指定元素是否包含在位数组
     */
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    public static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        /**
         * 计算hash值
         */
        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }

    }

}
