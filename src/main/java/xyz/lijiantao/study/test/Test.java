package xyz.lijiantao.study.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.util.Map;

/**
 * @author Jiantao Li
 * @date 2020/3/18 22:09
 */
public class Test {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        BaseRequestMessage request1 = new RequestMessage1(new Timestamp(System.currentTimeMillis()),"12444");
//        BaseRequestMessage request2 = new RequestMessage2(new Timestamp(System.currentTimeMillis()),"2345678");

        ((RequestMessage1) request1).setName("dd");
        ((RequestMessage1) request1).setSex("ddd");
        System.out.println(objectMapper.writeValueAsString(request1));
//        System.out.println(objectMapper.writeValueAsString(request2));
        System.out.println(objectMapper.readValue("{\"time\":\"2020-03-18 14:36:56\",\"request_id\":\"12444\"}",CentralizedReplyMessage.class));

        HeatingBean heatingBean = new HeatingBean(new Timestamp(System.currentTimeMillis()),"12444");
        heatingBean.setData(new ChuangYiBo("attr1","attr2"));

        Map map = BeanUtil.beanToMap(heatingBean,true,true);


        MapUtil.renameKey(map,"data","slave1");

//        Map<String,Object> map = new HashMap<>();
//        map.put("time","2020-03-18 15:30:00");
//        map.put("requestId","12444");
//        map.put("slave1",new ChuangYiBo("attr1","attr2"));


        System.out.println(objectMapper.writeValueAsString(map));
    }
}
