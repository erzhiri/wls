package com.erzhiri.wls.controller;

import com.erzhiri.wls.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @PostMapping("/redisTest")
    public Set<String> redisTest(@RequestBody String token) {
        redisTemplate.opsForSet().add("wls", token);
        Boolean member = redisTemplate.opsForSet().isMember("wls", token);
        if (member) {
            return redisTemplate.opsForSet().members("wls");
        }
        return null;
    }

    @GetMapping("/refresh")
    public String tokenRefresh(String token) {
        return tokenUtil.refreshToken(token);
    }
}
