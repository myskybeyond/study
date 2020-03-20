package xyz.lijiantao.study.proxy.mybatis.plugin.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 封装目标对象
 * @author Jiantao Li
 * @date 2019/8/30 16:01
 */
public class Invocation {

    private final Object target;
    private final Method method;
    private final Object[] args;

    public Invocation(Object target,Method method,Object[] args){
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object proceed() throws InvocationTargetException,IllegalAccessException{
        return method.invoke(target,args);
    }
}
