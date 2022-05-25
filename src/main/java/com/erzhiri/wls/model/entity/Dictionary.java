package com.erzhiri.wls.model.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Dictionary对象", description="字典")
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal dictionaryId;

    private String description;

    private BigDecimal previous;

    private Integer embed;


}
