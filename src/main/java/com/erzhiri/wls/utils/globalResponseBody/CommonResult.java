package com.erzhiri.wls.utils.globalResponseBody;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class CommonResult<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    public CommonResult() {
    }

    public CommonResult<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public CommonResult<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public CommonResult<T> data(T data) {
        this.setData(data);
        return this;
    }


}
