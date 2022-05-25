package com.erzhiri.wls.utils.constants;

import io.swagger.models.auth.In;

/**
 * @author erhziri
 * @version 0.1.0
 * @since 0.1.0
 **/
public interface StatusConstants {

    /**
     * 已发货
     */
    public static final Integer SHIPPED = 2;

    /**
     * 等待入库
     */
    public static final Integer PENDING_STORAGE = 3;

    /**
     * 库存中
     */
    public static  final Integer IN_STOCK = 4;

    /**
     * 长期存放中
     */
    public static final Integer LONG_TERM_STORAGE = 5;

    /**
     * 物流到客户
     */
    public static final Integer LOGISTICS_TO_CUSTOMER = 6;

    /**
     * 已送达
     */
    public static final Integer ARRIVED = 7;

    /**
     * 退回
     */
    public static final Integer RETURNED = 8;
}
