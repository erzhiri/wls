package com.erzhiri.wls.controller;


import com.erzhiri.wls.model.dto.StatusDTO;
import com.erzhiri.wls.service.IDictionaryService;
import com.erzhiri.wls.utils.globalResponseBody.CommonResult;
import com.erzhiri.wls.utils.globalResponseBody.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 字典 前端控制器
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("/statusInfo")
    public CommonResult<List<StatusDTO>> queryStatus() {
        List<StatusDTO> statusDTOList = dictionaryService.selectStatus();
        return RestHelper.ok(statusDTOList);
    }

}
