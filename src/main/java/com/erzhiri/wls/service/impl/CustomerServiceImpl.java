package com.erzhiri.wls.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erzhiri.wls.model.dto.LoginDTO;
import com.erzhiri.wls.model.entity.Customer;
import com.erzhiri.wls.mapper.CustomerMapper;
import com.erzhiri.wls.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erzhiri.wls.utils.JwtTokenUtil;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 客户 服务实现类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    JwtTokenUtil tokenUtil;

    @Override
    public Customer getInfoById(BigDecimal id) {
        Customer customer = customerMapper.selectById(id);
        customer.setPassword(null);
        return customer;
    }

    @Override
    public String login(LoginDTO dto) {
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        wrapper.eq("username", dto.getUsername());
        wrapper.eq("password", dto.getPassword());
        Customer customer = customerMapper.selectOne(wrapper);
        if (customer == null) {
            return null;
        }
        return tokenUtil.generateToken(customer.getCustomerId(), customer.getUsername(), dto.getRole());

    }
}
