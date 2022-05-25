package com.erzhiri.wls.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // String 类型 key 序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // String 类型 value 序列化器
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // Hash 类型 key 序列化器
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // Hash 类型 value 序列化器
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
