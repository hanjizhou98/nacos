package com.example.nacos.controller;

import com.alibaba.fastjson.JSON;
import com.example.nacos.config.NacosConfig;
import com.example.nacos.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class NacosController {

    @GetMapping("/get")
    public String getConfig() {
        return getStaticConfig();
    }

    private static String getStaticConfig() {
        NacosConfig nacosConfig = SpringContextUtil.getBean(NacosConfig.class);
        //这个len就是根据你nacos动态获取的值。完成
        log.info("ip: {}", nacosConfig.getRedisIp());
        log.info("password: {}", nacosConfig.getRedisPassword());
        return JSON.toJSONString(nacosConfig);
    }
}

