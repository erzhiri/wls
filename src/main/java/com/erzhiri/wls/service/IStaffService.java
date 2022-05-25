package com.erzhiri.wls.service;

import com.erzhiri.wls.model.dto.LoginDTO;
import com.erzhiri.wls.model.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface IStaffService extends IService<Staff> {

    /**
     * 员工登陆
     * @param dto
     * @return
     */
    String login(LoginDTO dto);
}
