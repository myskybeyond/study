package xyz.lijiantao.study.design.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jiantao Li
 * @date 2020/3/18 10:46
 */
@Slf4j
public class LucyBackHome extends AbstractBackHome {
    public LucyBackHome() {
        super("Lucy");
    }

    @Override
    public void ride() {
     log.debug("lucy by bus...");
    }

    @Override
    public void methodA(){

    }
}
