package com.erzhiri.wls.utils.globalResponseBody;


import com.erzhiri.wls.utils.globalResponseBody.exception.BaseExceptionEnum;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class RestHelper {
    public static <T> CommonResult<T> ok() {
        return ok(null);
    }

    public static <T> CommonResult<T> ok(T data) {
        return (CommonResult<T>) new CommonResult<>().code(200).data(data);
    }

    public static <T> CommonResult<T> fail(BaseExceptionEnum baseExceptionEnum) {
        log.info(baseExceptionEnum.getCode().toString());
        log.info(baseExceptionEnum.getMessage());
        return (CommonResult<T>) new CommonResult<>().code(baseExceptionEnum.getCode()).message(baseExceptionEnum.getMessage()).data(baseExceptionEnum.getMessage());
    }

    public static <T> CommonResult<T> fail(String message) {
        return (CommonResult<T>) new CommonResult<>().code(400).message(message);
    }
}
