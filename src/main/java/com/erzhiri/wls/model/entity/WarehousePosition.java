package com.erzhiri.wls.model.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 仓储表
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="WarehousePosition对象", description="仓储表")
public class WarehousePosition implements Serializable {

    private static final long serialVersionUID = 1L;

//    @MppMultiId
    private BigDecimal warehouse;

    private BigDecimal position;

    private String goodsId;

    private Boolean free;

    @TableLogic(value = "1")
    private Integer embed;




}
