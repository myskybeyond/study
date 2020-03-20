package xyz.lijiantao.study.polymorphic;

/**
 * @author Jiantao Li
 * @date 2020/1/10 16:32
 */
public class Test {

    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
        animal.sleep();
        animal.run();

        System.out.println(animal.num);
        System.out.println(Animal.age);

        ((Cat) animal).catchMouse();
        System.out.println(((Cat) animal).name);
    }
}
