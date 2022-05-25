package com.erzhiri.wls.service;

import com.erzhiri.wls.model.dto.StatusDTO;
import com.erzhiri.wls.model.entity.Dictionary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典 服务类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
public interface IDictionaryService extends IService<Dictionary> {

    /**
     * 獲取状态信息
     * @return
     */
    List<StatusDTO> selectStatus();
}
