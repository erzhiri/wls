package com.erzhiri.wls.controller;


import com.erzhiri.wls.model.dto.PositionInfoDTO;
import com.erzhiri.wls.model.vo.PositionVO;
import com.erzhiri.wls.service.IWarehousePositionService;
import com.erzhiri.wls.utils.globalResponseBody.CommonResult;
import com.erzhiri.wls.utils.globalResponseBody.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 仓储表 前端控制器
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/warehouse-position")
public class WarehousePositionController {

    @Autowired
    IWarehousePositionService positionService;

    @GetMapping("/positionVO")
    public CommonResult<List<PositionVO>> getPositionVO() {
        List<PositionVO> positionMap = positionService.getPositionVO();
        return RestHelper.ok(positionMap);
    }
}
