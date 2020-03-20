package xyz.lijiantao.study.proxy.mybatis.plugin.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jiantao Li
 * @date 2019/8/30 16:05
 */
public class Plugin implements InvocationHandler {

    private final Object target;
    private final Interceptor interceptor;

    public Plugin(Object target,Interceptor interceptor){
        this.target = target;
        this.interceptor = interceptor;
    }

    public static Object wrap(Object target,Interceptor interceptor){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),new Class[]{IGetStr.class},new Plugin(target,interceptor));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("getStrZero")){
            return interceptor.intercept(new Invocation(target,method,args));
        }
        return method.invoke(target,args);
    }
}
