package xyz.lijiantao.study.design.pattern;

/**
 * @author Jiantao Li
 * @date 2020/3/18 15:11
 */
public class Dog extends Animal {

    public String name = "dog";

    @Override
    protected void eat(){
        System.out.println(name);
        System.out.println("dog eat");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
