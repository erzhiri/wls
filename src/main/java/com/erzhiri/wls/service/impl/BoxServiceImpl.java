package com.erzhiri.wls.service.impl;

import com.erzhiri.wls.model.entity.Box;
import com.erzhiri.wls.mapper.BoxMapper;
import com.erzhiri.wls.service.IBoxService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 盒子 服务实现类
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Service
public class BoxServiceImpl extends ServiceImpl<BoxMapper, Box> implements IBoxService {

}
