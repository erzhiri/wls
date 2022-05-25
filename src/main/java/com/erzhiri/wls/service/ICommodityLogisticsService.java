package com.erzhiri.wls.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erzhiri.wls.model.entity.CommodityLogistics;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 货物物流 服务类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface ICommodityLogisticsService extends IService<CommodityLogistics> {

    /**
     * 自定义条件查询查询商品
     * @param page
     * @param condition
     * @return
     */
    Page<CommodityLogistics> selectList(Page<CommodityLogistics> page, CommodityLogistics condition);

    /**
     * 根据 id 列表查询
     * @param ids
     * @return
     */
    List<CommodityLogistics> selectList(String[] ids);

    /**
     * 出库
     * @param dto
     * @return
     */
    CommodityLogistics outStore(CommodityLogistics dto);

    /**
     * 拒绝入库
     * @param commodityLogistics
     * @return
     */
    boolean refuse(CommodityLogistics commodityLogistics);

    /**
     * 入库操作
     * @param commodityLogistics
     * @return
     */
    boolean enterStore(CommodityLogistics commodityLogistics);
}
