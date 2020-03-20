package xyz.lijiantao.study.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Jiantao Li
 * @date 2020/3/18 23:13
 */
@Data
public class HeatingBean extends BaseRequestMessage {

    public HeatingBean(Timestamp time, String requestId) {
        super(time, requestId);
    }

    private ChuangYiBo data;

}
