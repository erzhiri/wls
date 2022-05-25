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
 * 员工表
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Staff对象", description="员工表")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private BigDecimal staffId;

    private String name;

    private String nickname;

    private String password;

    private String phoneNumber;

    private String email;

    private String address;

    @TableLogic(value = "1", delval = "0")
    private Integer embed;


}
