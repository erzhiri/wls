package com.erzhiri.wls.mapper;

import com.erzhiri.wls.model.entity.Warehouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 仓库 Mapper 接口
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface WarehouseMapper extends BaseMapper<Warehouse> {

    /**
     * 查询空余仓位
     * @return
     */
    List<Integer> selectFreePositionNumber();

    /**
     * 查询全部仓位信息
     * @return
     */
    List<Integer> selectUsedPositionNumber();
}
