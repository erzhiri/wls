package com.erzhiri.wls.mapper;

import com.erzhiri.wls.model.dto.StatusDTO;
import com.erzhiri.wls.model.entity.Dictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 字典 Mapper 接口
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    /**
     * 状态信息
     * @return
     */
    List<StatusDTO> selectStatusInfo();
}
