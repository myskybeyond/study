package xyz.lijiantao.study.lock;

/**
 * 双重校验锁实现对象单例
 *
 * @author Jiantao Li
 * @date 2020/3/17 11:20
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
//        判断对象是否被实例过
        if (singleton == null) {
//            类对象加锁
            synchronized (Singleton.class) {

                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
