package com.erzhiri.wls.service;

import com.erzhiri.wls.model.dto.InfoDTO;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/
public interface ILoginService {

    /**
     * 获取登陆信息
     *
     * @param token
     * @return
     */
    InfoDTO getInfo(String token);
}
