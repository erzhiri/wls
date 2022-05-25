package com.erzhiri.wls.utils.globalResponseBody.exception;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/
public enum LoginError implements BaseExceptionEnum{

    /**
     * 用户名或密码错误
     */
    LOGIN_USERNAME_OR_PASSWORD_ERROR(2001, "用户名或密码错误")


    ;

    private Integer code;

    private String message;

    LoginError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
