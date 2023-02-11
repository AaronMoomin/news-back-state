package com.jie.result;

/**
 * 常用结果的枚举
 */
public enum ResultEnum implements IResult {
    SUCCESS(200, "成功"),
    VALIDATE_FAILED(400, "参数错误"),
    COMMON_FAILED(500, "系统错误"),
    FORBIDDEN(2004, "没有权限访问资源");

    private Integer code;
    private String message;

    //省略get、set方法和构造方法

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

