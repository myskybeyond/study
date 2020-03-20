package xyz.lijiantao.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jiantao Li
 * @date 2019/8/30 15:42
 */
public class RequestCostInvocationHandler implements InvocationHandler {

    private Object target;

    public RequestCostInvocationHandler(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("request")){
            long startTime = System.currentTimeMillis();
            method.invoke(target,args);
            System.out.println("request cost：" + (System.currentTimeMillis() - startTime));
        }

        return null;
    }

    public static void main(String[] args) {
        IUserService userService = (IUserService) Proxy.newProxyInstance(IUserService.class.getClassLoader(),new Class[]{IUserService.class},new RequestCostInvocationHandler(new UserServiceImpl()));

        IProductService productService = (IProductService) Proxy.newProxyInstance(IProductService.class.getClassLoader(),new Class[]{IProductService.class},new RequestCostInvocationHandler(new ProductServiceImpl()));

        userService.request();

        productService.request();

    }


}
