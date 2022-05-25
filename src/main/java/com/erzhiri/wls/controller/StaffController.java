package com.erzhiri.wls.controller;


import com.erzhiri.wls.model.entity.Staff;
import com.erzhiri.wls.service.IStaffService;
import com.erzhiri.wls.utils.PasswordUtils;
import com.erzhiri.wls.utils.globalResponseBody.CommonResult;
import com.erzhiri.wls.utils.globalResponseBody.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    IStaffService staffService;

    @PostMapping
    public CommonResult<String> updateInfo(@RequestBody Staff dto) {
        System.out.println(dto);
        dto.setPassword(PasswordUtils.encode(dto.getPassword()));
        staffService.updateById(dto);
        return RestHelper.ok("更新成功！");
    }


    @GetMapping("/info")
    public CommonResult<Staff> getInfo(BigDecimal id) {
        Staff staff = staffService.getById(id);
        return RestHelper.ok(staff);
    }

}
