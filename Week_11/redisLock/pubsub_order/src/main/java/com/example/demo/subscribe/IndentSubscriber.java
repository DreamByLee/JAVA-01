package com.example.demo.subscribe;

import com.example.demo.entity.IndentInfo;
import com.example.demo.service.IndentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IndentSubscriber implements MessageListener {
    @Autowired
    private IndentService indentService;
    @Override
    public void onMessage(Message message, byte[] bytes) {

        byte[] channel = message.getChannel();
        byte[] body = message.getBody();

        try {
            String title = new String(channel, "UTF-8");
            String content = StringEscapeUtils.unescapeJava(new String(body, "utf-8"));
            content = content.substring(1 , content.length()-1);
            log.info("消息频道：{}", title);
            log.info("消息内容:{}", content);

            //判断订阅通道
            if("createIndent".equals(title)){
                ObjectMapper mapper = new ObjectMapper();
                IndentInfo indentInfo = mapper.readValue(content, IndentInfo.class);
                //创建订单
                indentService.confirmCreateIndent(indentInfo);
            }
        } catch (Exception e) {
            log.error("", e);
        }

    }
}
