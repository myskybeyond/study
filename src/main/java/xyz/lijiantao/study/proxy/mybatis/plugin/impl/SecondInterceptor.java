package xyz.lijiantao.study.proxy.mybatis.plugin.impl;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Jiantao Li
 * @date 2019/8/30 16:12
 */
public class SecondInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) {
        try {
            return "plugin2 " + invocation.proceed() + " plugin2";
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }
}
