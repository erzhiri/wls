package com.erzhiri.wls.mapper;

import com.erzhiri.wls.model.entity.WarehousePosition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.erzhiri.wls.model.vo.PositionVO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 * 仓储表 Mapper 接口
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface WarehousePositionMapper extends BaseMapper<WarehousePosition> {

    /**
     * 获取仓位映射信息
     *
     * @return
     */
    List<PositionVO> getPositionMap();

    /**
     * 通过 goodsId 将其置空
     *
     * @param goodsId
     * @return
     */
    Integer setNullByGoodsId(String goodsId);


    /**
     * @return
     */
    List<Integer> selectUseByWarehouse();
}
