package xyz.lijiantao.study.proxy.mybatis.plugin.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiantao Li
 * @date 2019/8/30 16:13
 */
public class InterceptorChain {

    private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

    public Object pluginAll(Object target){
        for (Interceptor interceptor : interceptors){
            target = interceptor.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor){
        interceptors.add(interceptor);
    }
}
