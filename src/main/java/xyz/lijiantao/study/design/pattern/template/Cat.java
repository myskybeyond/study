package xyz.lijiantao.study.design.pattern.template;

import xyz.lijiantao.study.design.pattern.Animal;

/**
 * @author Jiantao Li
 * @date 2020/3/18 17:15
 */
public class Cat extends Animal {
    @Override
    protected void eat() {
        System.out.println("cat eating...");
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}
