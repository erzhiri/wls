package com.erzhiri.wls.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/

@Data
public class PositionVO {

    private String label;

    private Integer value;

    private List<PositionChildren> children;
}
