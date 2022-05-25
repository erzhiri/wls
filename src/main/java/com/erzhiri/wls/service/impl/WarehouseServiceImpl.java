package com.erzhiri.wls.service.impl;

import com.erzhiri.wls.model.dto.PositionInfoDTO;
import com.erzhiri.wls.model.entity.Warehouse;
import com.erzhiri.wls.mapper.WarehouseMapper;
import com.erzhiri.wls.service.IWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 仓库 服务实现类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements IWarehouseService {

    @Autowired
    WarehouseMapper warehouseMapper;

    @Override
    public PositionInfoDTO getPositionInfo() {
        List<Integer> free = warehouseMapper.selectFreePositionNumber();
        List<Integer> used = warehouseMapper.selectUsedPositionNumber();
        PositionInfoDTO infoDTO = new PositionInfoDTO();
        infoDTO.setFree(free);
        infoDTO.setUsed(used);
        return infoDTO;
    }

    @Override
    public boolean enterStore(BigDecimal warehouseId) {
        Warehouse warehouse = warehouseMapper.selectById(warehouseId);
        warehouse.setFreePositionNumber(warehouse.getFreePositionNumber().subtract(BigDecimal.ONE));
        warehouseMapper.updateById(warehouse);
        return true;
    }

    @Override
    public boolean outStore(BigDecimal warehouseId) {
        Warehouse warehouse = warehouseMapper.selectById(warehouseId);
        warehouse.setFreePositionNumber(warehouse.getFreePositionNumber().add(BigDecimal.ONE));
        warehouseMapper.updateById(warehouse);
        return true;
    }
}
