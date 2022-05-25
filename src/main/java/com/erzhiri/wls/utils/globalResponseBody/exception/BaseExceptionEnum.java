package com.erzhiri.wls.utils.globalResponseBody.exception;

public interface BaseExceptionEnum {

    /**
     * 获取异常编码
     * @return code
     */
    Integer getCode();

    /**
     * 获取异常信息
     * @return message
     */
    String getMessage();
}
