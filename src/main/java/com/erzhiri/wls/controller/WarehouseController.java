package com.erzhiri.wls.controller;


import com.erzhiri.wls.model.dto.PositionInfoDTO;
import com.erzhiri.wls.service.IWarehouseService;
import com.erzhiri.wls.utils.globalResponseBody.CommonResult;
import com.erzhiri.wls.utils.globalResponseBody.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 仓库 前端控制器
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    IWarehouseService warehouseService;

    @GetMapping("/positionInfo")
    public CommonResult<PositionInfoDTO> getPositionInfo() {
        PositionInfoDTO positionInfo = warehouseService.getPositionInfo();
        return RestHelper.ok(positionInfo);
    }
}
