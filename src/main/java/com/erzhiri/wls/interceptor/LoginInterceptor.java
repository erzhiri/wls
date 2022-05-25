package com.erzhiri.wls.interceptor;

import com.erzhiri.wls.utils.JwtTokenUtil;
import com.erzhiri.wls.utils.globalResponseBody.CommonResult;
import com.erzhiri.wls.utils.globalResponseBody.RestHelper;
import com.erzhiri.wls.utils.globalResponseBody.exception.BaseExceptionEnum;
import com.erzhiri.wls.utils.globalResponseBody.exception.TokenError;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${jwt.redisToken}")
    private String redisToken;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        log.info("preHandle 拦截的请求路径{}", requestURL);
        String token = request.getHeader("WLS-Token");
        log.info("token:{}", token);
        if (token == null) {
            // 返回未登陆
            this.loginFailed(response, TokenError.TOKEN_WITHOUT);
            return false;
        }
        // 进行 token 校验
        if (!redisTemplate.opsForSet().isMember(redisToken, token)) {
            this.loginFailed(response, TokenError.TOKEN_AUTHENTICATION_FAILED);
            return false;
        }
        // 判断 token 是否过期
        boolean validateToken = false;
        try {
            validateToken = tokenUtil.validateToken(token);
        } catch (ExpiredJwtException e) {
            this.loginFailed(response, TokenError.TOKEN_OUT_OF_DATE);
            redisTemplate.opsForSet().remove(redisToken, token);
            return false;
        }
        return true;
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


    /**
     * 私有方法，拒绝访问后的响应设置
     * @param response
     * @param exception
     * @throws IOException
     */
    private void loginFailed(HttpServletResponse response, BaseExceptionEnum exception) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        CommonResult<String> fail = RestHelper.fail(exception);
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().println(objectMapper.writeValueAsString(fail));
    }
}
