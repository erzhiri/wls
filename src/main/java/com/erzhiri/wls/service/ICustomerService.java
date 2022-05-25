package com.erzhiri.wls.service;

import com.erzhiri.wls.model.dto.LoginDTO;
import com.erzhiri.wls.model.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 * 客户 服务类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface ICustomerService extends IService<Customer> {

    /**
     * 根据 id 获取用户信息
     * @param id
     * @return
     */
    Customer getInfoById(BigDecimal id);

    /**
     * 用户登陆
     * @param dto
     * @return
     */
    String login(LoginDTO dto);
}
