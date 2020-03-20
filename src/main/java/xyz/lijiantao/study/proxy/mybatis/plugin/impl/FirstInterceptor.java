package xyz.lijiantao.study.proxy.mybatis.plugin.impl;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Jiantao Li
 * @date 2019/8/30 16:10
 */
public class FirstInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) {
        try {
            return "plugin1 " + invocation.proceed() + " plugin1";
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
