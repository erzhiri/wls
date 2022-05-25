package com.erzhiri.wls.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erzhiri.wls.model.dto.LoginDTO;
import com.erzhiri.wls.model.entity.Staff;
import com.erzhiri.wls.mapper.StaffMapper;
import com.erzhiri.wls.service.IStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erzhiri.wls.utils.JwtTokenUtil;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {

    @Autowired
    StaffMapper staffMapper;

    @Autowired
    JwtTokenUtil tokenUtil;

    @Override
    public String login(LoginDTO dto) {
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.eq("name", dto.getUsername());
        wrapper.eq("password", dto.getPassword());
        Staff staff = staffMapper.selectOne(wrapper);
        if (staff == null) {
            return null;
        }
        // 生成 token
        return tokenUtil.generateToken(staff.getStaffId(), staff.getName(), dto.getRole());
    }
}
