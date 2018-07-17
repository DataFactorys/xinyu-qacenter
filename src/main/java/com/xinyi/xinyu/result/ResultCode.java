package com.xinyi.xinyu.result;

/**
 * Created by 10067610 on 15/8/24.
 */
public enum ResultCode {
    DEFAULT_ERROR(0, "操作失败"),
    DEFAULT_SUCCESS(1, "操作成功"),
    OBJECT_IS_NULL(1001, "查不到记录"),
    PARAMS_IS_ERROR(1002, "参数错误"),
    DATA_DB_EFFECTS_ZERO(1003, "数据库影响记录为0"),
    LOGIN_NO_USER(1004, "用户不存在"),
    LOGIN_PASSWORD_WRONG(1005, "密码错误"),
    PARAMS_IS_NOT_NUMERIC(1006, "参数非数字"),
    DATA_IS_DULPLICATE(1007,"重复添加"),
    USER_NOT_EXISTS(1008,"查不到该JIRA用户"),
    END(12100, "");

    private int code;

    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {

        return code == DEFAULT_SUCCESS.getCode();
    }

}
