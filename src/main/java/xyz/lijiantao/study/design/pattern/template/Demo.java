package xyz.lijiantao.study.design.pattern.template;

/**
 * @author Jiantao Li
 * @date 2020/3/18 10:46
 */
public class Demo {

    public static void main(String[] args) {
        AbstractBackHome leiBackHome = new LiLeiBackHome();
        leiBackHome.backHome();
        leiBackHome.methodA();
        AbstractBackHome lucyBackHome = new LucyBackHome();
        lucyBackHome.backHome();
        lucyBackHome.methodA();


    }
}
