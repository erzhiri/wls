package com.erzhiri.wls.service.impl;

import com.erzhiri.wls.model.dto.StatusDTO;
import com.erzhiri.wls.model.entity.Dictionary;
import com.erzhiri.wls.mapper.DictionaryMapper;
import com.erzhiri.wls.service.IDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典 服务实现类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public List<StatusDTO> selectStatus() {
        List<StatusDTO> statusDTOList = dictionaryMapper.selectStatusInfo();
        return statusDTOList;
    }
}
