package com.erzhiri.wls.controller;

import com.erzhiri.wls.model.dto.InfoDTO;
import com.erzhiri.wls.model.dto.LoginDTO;
import com.erzhiri.wls.service.ICustomerService;
import com.erzhiri.wls.service.ILoginService;
import com.erzhiri.wls.service.IStaffService;
import com.erzhiri.wls.utils.PasswordUtils;
import com.erzhiri.wls.utils.globalResponseBody.CommonResult;
import com.erzhiri.wls.utils.globalResponseBody.RestHelper;
import com.erzhiri.wls.utils.globalResponseBody.exception.LoginError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/

@Slf4j
@RestController
public class LoginController {

    private static final String ROLE = "admin";

    @Value("${jwt.redisToken}")
    private String redisToken;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    ILoginService loginService;

    @Autowired
    IStaffService staffService;

    @Autowired
    ICustomerService customerService;

    @PostMapping("/login")
    public CommonResult<?> login(@RequestBody LoginDTO dto) {
        log.info(dto.toString());
        String role = dto.getRole();
        if (role == null) {
            //
            return RestHelper.fail("角色信息错误");
        }
        // 登陆，生成 token
        String token;
        // 密码加密
        dto.setPassword(PasswordUtils.encode(dto.getPassword()));
        // 根据角色信息进行登陆判定
        if (role.equals(ROLE)) {
            token = staffService.login(dto);
        } else {
            token = customerService.login(dto);
        }
        if (token == null) {
            CommonResult<Object> fail = RestHelper.fail(LoginError.LOGIN_USERNAME_OR_PASSWORD_ERROR);
            return fail;
        }
        // 存储 token 到 redis
        redisTemplate.opsForSet().add(redisToken, token);
        return RestHelper.ok(token);
    }


    @GetMapping("/info")
    public CommonResult<?> getInfo(@RequestParam String token) {
        log.info(token);
        InfoDTO info = loginService.getInfo(token);
        return RestHelper.ok(info);
    }


    @PostMapping("/logout")
    public CommonResult<String> logout(HttpServletRequest request) {
        String token = request.getHeader("WLS-Token");
        redisTemplate.opsForSet().remove(redisToken, token);
        return RestHelper.ok();
    }
}
