package com.erzhiri.wls.service.impl;

import com.erzhiri.wls.model.dto.InfoDTO;
import com.erzhiri.wls.service.ILoginService;
import com.erzhiri.wls.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    JwtTokenUtil jwtTokenUtil;



    @Override
    public InfoDTO getInfo(String token) {
        InfoDTO infoDTO = jwtTokenUtil.getInfoFromToken(token);
        return infoDTO;
    }
}
