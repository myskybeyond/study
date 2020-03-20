package xyz.lijiantao.study.design.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * 模板方法设计模式实现
 * @author Jiantao Li
 * @date 2020/3/18 10:45
 */
@Slf4j
public class LiLeiBackHome extends AbstractBackHome {
    public LiLeiBackHome() {
        super("liLei");
    }

    @Override
    public void ride() {
        log.debug("liLei ride bike...");
    }

    @Override
    public void methodA() {
        log.debug("methodA execute...");
    }
}
