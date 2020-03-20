package xyz.lijiantao.study.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jiantao Li
 * @date 2020/3/18 23:14
 */
@Data
public class ChuangYiBo {

    private String attr1;
    private String attr2;

    public ChuangYiBo(String attr1,String attr2){
        this.attr1 = attr1;
        this.attr2 =attr2;
    }
}
