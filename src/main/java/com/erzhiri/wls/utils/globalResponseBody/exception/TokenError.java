package com.erzhiri.wls.utils.globalResponseBody.exception;
/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/
public enum TokenError implements BaseExceptionEnum{

    /**
     * 登陆凭证已过期
     */
    TOKEN_OUT_OF_DATE(5000, "您的登陆凭证已过期, 请重新登陆"),

    /**
     * 登陆凭证已失效
     */
    TOKEN_AUTHENTICATION_FAILED(5003, "登陆凭证不存在或已失效"),

    /**
     * 登陆凭证解析失败
     */
    TOKEN_PARSE_FAIL(5001, "登陆凭证解析失败，非法凭证，请重新登陆"),

    /**
     * 无登陆凭证
     */
    TOKEN_WITHOUT(5002, "无登陆凭证，请登陆");


    private Integer code;

    private String message;

    TokenError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public java.lang.Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
