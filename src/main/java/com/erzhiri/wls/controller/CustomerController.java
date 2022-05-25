package com.erzhiri.wls.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erzhiri.wls.model.entity.Customer;
import com.erzhiri.wls.service.ICustomerService;
import com.erzhiri.wls.utils.PasswordUtils;
import com.erzhiri.wls.utils.globalResponseBody.CommonResult;
import com.erzhiri.wls.utils.globalResponseBody.RestHelper;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 * 客户 前端控制器
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping
    public CommonResult<Page<Customer>> query(Page<Customer> page) {
        customerService.page(page);
        return RestHelper.ok(page);
    }


    @GetMapping("/{id}")
    public CommonResult<Customer> getInfo(@PathVariable BigDecimal id) {
        Customer customer = customerService.getInfoById(id);
        return RestHelper.ok(customer);
    }

    @PostMapping
    public CommonResult<String> submit(@RequestBody Customer dto) {
        // 进行密码加密
        dto.setPassword(PasswordUtils.encode(dto.getPassword()));
        customerService.updateById(dto);
        return RestHelper.ok("success");
    }
}
