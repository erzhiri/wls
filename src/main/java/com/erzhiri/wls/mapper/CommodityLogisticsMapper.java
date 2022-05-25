package com.erzhiri.wls.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erzhiri.wls.model.entity.CommodityLogistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 货物物流 Mapper 接口
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface CommodityLogisticsMapper extends BaseMapper<CommodityLogistics> {


    /**
     * 自定义条件查询
     * @param page
     * @param condition
     * @return
     */
    Page<CommodityLogistics> selectPage(IPage<CommodityLogistics> page,
                                        @Param("condition") CommodityLogistics condition);

    /**
     * 根据 id 查询
     * @param ids
     * @return
     */
    List<CommodityLogistics> selectByIds(String[] ids);
}
