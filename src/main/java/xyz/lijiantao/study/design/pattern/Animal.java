package xyz.lijiantao.study.design.pattern;

/**
 * @author Jiantao Li
 * @date 2020/3/18 15:10
 */
public abstract class Animal {


    public String name = "Animal";

    public Animal(){
    }

    protected abstract void eat();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
