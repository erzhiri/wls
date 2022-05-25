package com.erzhiri.wls.service;

import com.erzhiri.wls.model.dto.PositionInfoDTO;
import com.erzhiri.wls.model.entity.WarehousePosition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.erzhiri.wls.model.vo.PositionVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 仓储表 服务类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface IWarehousePositionService extends IService<WarehousePosition> {

    /**
     * 获取仓位表
     * @return
     */
    List<PositionVO> getPositionVO();

    /**
     * 出库清仓
     * @param id
     * @return
     */
    boolean outStore(String id);

    /**
     * 查询仓位信息
     * @return
     */
    PositionInfoDTO getPositionInfo();


    /**
     * 入库
     * @param warehouseId
     * @param position
     * @param goodsId
     * @return
     */
    boolean enterStore(BigDecimal warehouseId, BigDecimal position, String goodsId);
}
