package com.erzhiri.wls.model.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/

@Data
public class PositionChildren {

    private String label;

    private BigDecimal value;

    private boolean disabled;
}
