package com.demo.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * String 类型的value值
 *
 * RedisTemplate<String, String>
 *
 * @author czy
 * @date 2021/9/3
 */
@Component
public class StringRedisConfig {
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf){
        return new StringRedisTemplate(cf);
    }
}
