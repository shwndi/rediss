package com.demo.redis.redisionconfig;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson 配置
 * @author czy
 * @date 2021/11/22
 */
@Configuration
@Data
public class RedissonConfig {
    @Value("${spring.redisson.host}")
    private String host;

    @Value("${spring.redisson.port}")
    private String port;

    @Value("${spring.redisson.password}")
    private String password;

    @Bean(name = "redisson")
    public RedissonClient getRedisson(){

        Config config = new Config();
        config.setCodec(new FastJsonCodec());
        config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password);
        //添加主从配置
//        config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});

        return Redisson.create(config);
    }
}
