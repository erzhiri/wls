package com.erzhiri.wls.controller;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erzhiri.wls.model.entity.CommodityLogistics;
import com.erzhiri.wls.service.ICommodityLogisticsService;
import com.erzhiri.wls.utils.constants.StatusConstants;
import com.erzhiri.wls.utils.globalResponseBody.CommonResult;
import com.erzhiri.wls.utils.globalResponseBody.RestHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 货物物流 前端控制器
 * </p>
 *
 * @author erzhiri
 */

@Slf4j
@RestController
@RequestMapping("/commodity-logistics")
public class CommodityLogisticsController {

    @Autowired
    ICommodityLogisticsService commodityLogisticsService;


    @GetMapping
    public CommonResult<Page<CommodityLogistics>> query(Page<CommodityLogistics> page, CommodityLogistics dto) {
        //TODO 对 page 值进行校验
        log.info(dto.toString());
        commodityLogisticsService.selectList(page, dto);
        return RestHelper.ok(page);
    }


    @PostMapping
    public CommonResult<CommodityLogistics> submit(@RequestBody CommodityLogistics dto) {
        if (dto.getId() != null) {
            commodityLogisticsService.updateById(dto);
        } else {
            commodityLogisticsService.save(dto);
        }
        return null;
    }

    @PostMapping("/send")
    public CommonResult<CommodityLogistics> send(@RequestBody CommodityLogistics dto) {
        log.info(dto.toString());
        dto.setStatus(StatusConstants.IN_STOCK);
        commodityLogisticsService.updateById(dto);
        return RestHelper.ok(dto);
    }

    @PostMapping("/outStore")
    public CommonResult<CommodityLogistics> outStore(@RequestBody CommodityLogistics dto) {
        log.info(dto.toString());
        commodityLogisticsService.outStore(dto);
        return RestHelper.ok(dto);
    }

    @PostMapping("/refuse")
    public CommonResult<CommodityLogistics> refuse(@RequestBody CommodityLogistics dto) {
        log.info(dto.toString());
        commodityLogisticsService.refuse(dto);
        return RestHelper.ok(dto);
    }

    @PostMapping("/printfRecord")
    public CommonResult<?> printfRecord(@RequestBody String[] ids, HttpServletResponse response) {
        log.info(ids.toString());
        if (ids.length == 0) {
            return RestHelper.fail("未选中");
        }
        List<CommodityLogistics> list = commodityLogisticsService.selectList(ids);
        // 设置返回值
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和 easyExcel 没有关系
        String fileName = null;
        try {
            fileName = URLEncoder.encode("导出表格", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), CommodityLogistics.class).sheet("模板").doWrite(list);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/enterStore")
    public CommonResult<String> enterStore(@RequestBody CommodityLogistics dto) {
        log.info(dto.toString());
        boolean b = commodityLogisticsService.enterStore(dto);
        if (!b) {
            return RestHelper.fail("入库失败");
        }
        return RestHelper.ok("入库成功");
    }
}
