package com.erzhiri.wls.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erzhiri.wls.mapper.WarehouseMapper;
import com.erzhiri.wls.mapper.WarehousePositionMapper;
import com.erzhiri.wls.model.entity.CommodityLogistics;
import com.erzhiri.wls.mapper.CommodityLogisticsMapper;
import com.erzhiri.wls.model.entity.WarehousePosition;
import com.erzhiri.wls.service.ICommodityLogisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erzhiri.wls.service.IWarehousePositionService;
import com.erzhiri.wls.service.IWarehouseService;
import com.erzhiri.wls.utils.constants.LocationConstants;
import com.erzhiri.wls.utils.constants.StatusConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 货物物流 服务实现类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Service
public class CommodityLogisticsServiceImpl extends ServiceImpl<CommodityLogisticsMapper, CommodityLogistics> implements ICommodityLogisticsService {

    @Autowired
    CommodityLogisticsMapper logisticsMapper;


    @Autowired
    IWarehousePositionService positionService;

    @Autowired
    IWarehouseService warehouseService;

    @Override
    public Page<CommodityLogistics> selectList(Page<CommodityLogistics> page, CommodityLogistics condition) {
        Page<CommodityLogistics> selectPage = logisticsMapper.selectPage(page, condition);
        return page;
    }

    @Override
    public List<CommodityLogistics> selectList(String[] ids) {
       return logisticsMapper.selectByIds(ids);
    }

    @Override
    public CommodityLogistics outStore(CommodityLogistics dto) {
        // 修改当前状态
        dto.setStatus(StatusConstants.LOGISTICS_TO_CUSTOMER);
        // 设置出库时间
        dto.setOutStoreTime(new Date());
        // 出库
        warehouseService.outStore(dto.getWarehouseId());
        boolean result = positionService.outStore(dto.getId());
        // 仓库置空
        dto.setWarehouseId(null);
        logisticsMapper.updateById(dto);
        return dto;
    }

    @Override
    public boolean refuse(CommodityLogistics commodityLogistics) {
        // 改变当前状态
        commodityLogistics.setStatus(StatusConstants.RETURNED);
        // 更新数据
        try {
            logisticsMapper.updateById(commodityLogistics);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean enterStore(CommodityLogistics commodityLogistics) {
        // 根据 id 查询此条信息
        CommodityLogistics commodityLogisticsInfo = logisticsMapper.selectById(commodityLogistics.getId());
        // 根据目的地位置信息改变状态
        if (commodityLogisticsInfo.getLocationTo().equals(LocationConstants.address)) {
            commodityLogistics.setStatus(StatusConstants.LONG_TERM_STORAGE);
        } else {
            commodityLogistics.setStatus(StatusConstants.IN_STOCK);
        }
        // 设置入库时间
        commodityLogistics.setEnterStoreTime(new Date());
        // 更新货物信息
        logisticsMapper.updateById(commodityLogistics);
        // 更新仓位信息
        positionService.enterStore(commodityLogistics.getWarehouseId(), commodityLogistics.getPosition(), commodityLogistics.getId());

        // 更新仓库信息
        warehouseService.enterStore(commodityLogistics.getWarehouseId());

        return true;
    }
}
