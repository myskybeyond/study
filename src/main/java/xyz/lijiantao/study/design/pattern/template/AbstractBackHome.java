package xyz.lijiantao.study.design.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jiantao Li
 * @date 2020/3/18 10:40
 */
@Slf4j
public abstract class AbstractBackHome {

    private String name;

    public AbstractBackHome(String name){
        this.name = name;
    }

    public void backHome() {
        log.debug("{} want go home now...",name);
        log.debug("let's go...");
        buyTicket();
        securityCheck();
        ride();
        arrive();
        log.debug("finished...");
    }

    protected final void buyTicket() {
        log.debug("{} am buy ticket now...",name);
    }

    protected final void securityCheck() {
        log.debug("{} am security check now...",name);
    }

    public abstract void ride();

    protected final void arrive() {
        log.debug("{} am arrived...",name);
    }

    public void methodA(){
        throw new RuntimeException();
    }
}
