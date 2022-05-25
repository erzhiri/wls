package com.erzhiri.wls.service;

import com.erzhiri.wls.model.dto.PositionInfoDTO;
import com.erzhiri.wls.model.entity.Warehouse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 * 仓库 服务类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface IWarehouseService extends IService<Warehouse> {

    /**
     * 获取仓位信息
     * @return
     */
    PositionInfoDTO getPositionInfo();

    /**
     * 入库
     * @param warehouseId
     * @return
     */
    boolean enterStore(BigDecimal warehouseId);

    /**
     * 出库
     * @param warehouseId
     * @return
     */
    boolean outStore(BigDecimal warehouseId);
}
