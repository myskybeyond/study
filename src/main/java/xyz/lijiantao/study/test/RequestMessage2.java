package xyz.lijiantao.study.test;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Jiantao Li
 * @date 2020/3/18 22:09
 */
@Data
public class RequestMessage2 extends BaseRequestMessage {
    public RequestMessage2(Timestamp time, String requestId) {
        super(time, requestId);
    }

    private String attr1;
    private String attr2;
}
