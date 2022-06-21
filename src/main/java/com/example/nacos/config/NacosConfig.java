package com.example.nacos.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Data
@RefreshScope
@NoArgsConstructor
public class NacosConfig {

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;


    public String redisIp;

    public String getRedisIp() {
        return redisIp = configurableApplicationContext.getEnvironment().getProperty(NacosConstants.redisIp);
    }

    public String redisPassword = configurableApplicationContext.getEnvironment().getProperty("gov.redis.password");


}

