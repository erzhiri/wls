package com.erzhiri.wls.controller;


import com.erzhiri.wls.utils.globalResponseBody.CommonResult;
import com.erzhiri.wls.utils.globalResponseBody.RestHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 盒子 前端控制器
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/box")
public class BoxController {

    @GetMapping("/test")
    public CommonResult<String> test() {
        return RestHelper.ok("test");
    }
}
