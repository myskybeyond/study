package xyz.lijiantao.study.mianshi.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author Jiantao Li
 * @date 2020/2/12 10:45
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("字符串类型测试");
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";

        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));

        filter.add(value1);
        filter.add(value2);

        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));

        System.out.println("Integer类型数据测试");
        Integer value3 = 13423;
        Integer value4 = 22131;

        MyBloomFilter filter1 = new MyBloomFilter();
        System.out.println(filter.contains(value3));
        System.out.println(filter.contains(value4));

        filter.add(value3);
        filter.add(value4);

        System.out.println(filter.contains(value3));
        System.out.println(filter.contains(value4));

        System.out.println("Google开源的Guava中的布隆过滤器");
        BloomFilter<Integer> filter2 = BloomFilter.create(Funnels.integerFunnel(),1500,0.01);
        System.out.println(filter2.mightContain(1));
        System.out.println(filter2.mightContain(2));
        filter2.put(1);
        filter2.put(2);
        System.out.println(filter2.mightContain(1));
        System.out.println(filter2.mightContain(2));
    }
}
