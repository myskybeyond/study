package xyz.lijiantao.study.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author Jiantao Li
 * @date 2020/3/18 22:05
 */
@Data
public class RequestMessage1 extends BaseRequestMessage {
    public RequestMessage1(Timestamp time, String requestId) {
        super(time, requestId);
        this.repeatRequestId = requestId;
    }

    private String name;
    private String sex;
    /**
     * 为兼容集中式MQTT
     * request_id
     */
    @NotNull
    @JsonProperty("request_id")
    private String repeatRequestId;
}
