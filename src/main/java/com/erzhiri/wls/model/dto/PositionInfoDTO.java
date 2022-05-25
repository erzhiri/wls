package com.erzhiri.wls.model.dto;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/

@Data
public class PositionInfoDTO {

    private List<Integer> used;

    private List<Integer> free;

}
