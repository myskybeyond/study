package xyz.lijiantao.study.proxy.mybatis.plugin.impl;

/**
 * @author Jiantao Li
 * @date 2019/8/30 16:16
 */
public class Test {

    public static void main(String[] args) {
//        配置插件
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptor(new FirstInterceptor());
        interceptorChain.addInterceptor(new SecondInterceptor());

//        获取代理对象
        IGetStr getStr = new GetStr();
        getStr = (IGetStr) interceptorChain.pluginAll(getStr);

        String result = getStr.getStrZero();

        System.out.println(result);

        result = getStr.getStrOne();
        System.out.println(result);

    }
}
