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
 * 客户
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Customer对象", description="客户")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private BigDecimal customerId;

    private String username;

    private String password;

    private String possCode;

    private String address;

    private String phoneNumber;

    private String bank;

    private String account;

    @TableLogic(value = "1")
    private Integer embed;


}
