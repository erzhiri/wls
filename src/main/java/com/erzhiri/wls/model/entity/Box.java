package com.erzhiri.wls.model.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 盒子
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Box对象", description="盒子")
public class Box implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private BigDecimal length;

    private BigDecimal width;

    private BigDecimal height;

    private Integer embed;


}
