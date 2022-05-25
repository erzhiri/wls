package com.erzhiri.wls.model.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 仓库
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Warehouse对象", description="仓库")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private BigDecimal warehouseId;

    private BigDecimal freePositionNumber;

    private BigDecimal alarmNumber;

    @TableLogic(value = "1", delval = "0")
    private Integer embed;

    private BigDecimal allPositionNumber;


}
