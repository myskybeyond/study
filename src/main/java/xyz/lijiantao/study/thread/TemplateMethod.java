package xyz.lijiantao.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Jiantao Li
 * @date 2019/8/29 17:58
 */
public class TemplateMethod {

    public final void print(String message){
        System.out.println("##########");
        wrapPrint(message);
        System.out.println("##########");
    }

    protected void wrapPrint(String message){

    }

    public void recycle(){
        for(;;){
            System.out.println("hello world!!!");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message){
                System.out.println("*"+ message + "*");
            }
        };
        t1.print("Hello thread");
        TemplateMethod t2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message){
                System.out.println("+" + message + "+");
            }
        };
        t2.print("hello thread");
        t2.recycle();
    }
}
