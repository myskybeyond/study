package xyz.lijiantao.study.design.pattern;

import com.alibaba.fastjson.JSON;
import xyz.lijiantao.study.design.pattern.template.Cat;

/**
 * @author Jiantao Li
 * @date 2020/3/18 15:13
 */
public class Test {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        System.out.println(dog.toString());
        System.out.println(JSON.toJSON(dog));
        System.out.println(JSON.toJSON(cat));
        Object obj = JSON.toJSON(dog);
        System.out.println(obj.toString().replace("name","name1"));
    }
}
