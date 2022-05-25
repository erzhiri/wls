package com.erzhiri.wls.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erzhiri.wls.model.dto.PositionInfoDTO;
import com.erzhiri.wls.model.entity.WarehousePosition;
import com.erzhiri.wls.mapper.WarehousePositionMapper;
import com.erzhiri.wls.model.vo.PositionVO;
import com.erzhiri.wls.service.IWarehousePositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 仓储表 服务实现类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Service
public class WarehousePositionServiceImpl extends ServiceImpl<WarehousePositionMapper, WarehousePosition> implements IWarehousePositionService {

    @Autowired
    WarehousePositionMapper positionMapper;

    @Override
    public List<PositionVO> getPositionVO() {

        return positionMapper.getPositionMap();

    }

    @Override
    public boolean outStore(String id) {
        Integer result = positionMapper.setNullByGoodsId(id);
        if (result == 1) {
            return true;
        }
        return false;
    }

    @Override
    public PositionInfoDTO getPositionInfo() {
        List<Integer> list = positionMapper.selectUseByWarehouse();
        System.out.println(list);
        return null;
    }

    @Override
    public boolean enterStore(BigDecimal warehouseId, BigDecimal position, String goodsId) {
        QueryWrapper<WarehousePosition> wrapper = new QueryWrapper<>();
        wrapper.eq("warehouse", warehouseId);
        wrapper.eq("position", position);
        WarehousePosition warehousePosition = positionMapper.selectOne(wrapper);
        // 更新仓位信息
        warehousePosition.setFree(false);
        warehousePosition.setGoodsId(goodsId);
        positionMapper.update(warehousePosition, wrapper);
        return true;
    }
}
