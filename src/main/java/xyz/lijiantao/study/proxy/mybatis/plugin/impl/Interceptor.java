package xyz.lijiantao.study.proxy.mybatis.plugin.impl;

/**
 * @author Jiantao Li
 * @date 2019/8/30 16:00
 */
public interface Interceptor {

    Object intercept(Invocation invocation);

    Object plugin(Object target);
}
