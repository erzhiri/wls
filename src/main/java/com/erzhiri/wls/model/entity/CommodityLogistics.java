package com.erzhiri.wls.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 货物物流
 * </p>
 *
 * @author erzhiri
 * @since 2022-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CommodityLogistics对象", description="货物物流")
@TableName("commodity_logistics")
public class CommodityLogistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "编号", index = 0)
    @TableId
    private String id;

    @ExcelProperty(value = "商品名称", index = 1)
    private String goodsName;

    @ExcelProperty(value = "用户名", index = 2)
    @TableField(exist = false)
    private String username;

    @ExcelProperty(value = "交易单号", index = 3)
    private String transCode;

    @ExcelProperty(value = "体积", index = 4)
    @TableField(exist = false)
    private String volume;

    @ExcelProperty(value = "重量", index = 5)
    private BigDecimal weight;

    @ExcelProperty(value = "盒子型号", index = 6)
    private String box;


    @ExcelProperty(value = "备注", index = 7)
    private String remark;

    @ExcelProperty(value = "仓位", index = 8)
    @TableField(exist = false)
    private BigDecimal position;

    @ExcelProperty(value = "仓库", index = 9)
    private BigDecimal warehouseId;

    @ExcelProperty(value = "发货地", index = 10)
    private String locationFrom;

    @ExcelProperty(value = "目的地", index = 11)
    private String locationTo;

    @ExcelIgnore
    private BigDecimal customerId;

    @ExcelIgnore
    private Date enterStoreTime;

    @ExcelIgnore
    private Date outStoreTime;

    @ExcelIgnore
    @TableLogic(value = "1", delval = "0")
    private Integer embed;

    @ExcelIgnore
    private Integer status;


    @ExcelIgnore
    @TableField(exist = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @ExcelIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(exist = false)
    private Date toDate;
}
