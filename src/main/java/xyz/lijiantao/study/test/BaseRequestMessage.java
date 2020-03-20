package xyz.lijiantao.study.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public abstract class BaseRequestMessage {
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Timestamp time;

    @NotNull(message="requestId is not null")
    String requestId;

    public BaseRequestMessage(Timestamp time, String requestId){
        this.time = time;
        this.requestId = requestId;
    }
}
