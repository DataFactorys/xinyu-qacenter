package com.xinyi.xinyu.result;

import java.io.Serializable;

/**
 * Created by 10067610 on 15/7/30.
 */
public class Result<T> implements Serializable {

    private boolean status;

    private String message;

    private int responseCode;

    private T entry;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getEntry() {
        return entry;
    }

    public void setEntry(T entry) {
        this.entry = entry;
    }

    public static Result Failure() {
        Result result = new Result();
        result.setStatus(false);
        // 失败的ResponseCode默认值为0
        result.setResponseCode(ResultCode.DEFAULT_ERROR.getCode());
        result.setMessage(ResultCode.DEFAULT_ERROR.getMessage());
        return result;
    }

    public static Result Failure(String msg) {
        Result result = Failure();
        // 失败的ResponseCode默认值为0
        result.setResponseCode(ResultCode.DEFAULT_ERROR.getCode());
        result.setMessage(msg);
        return result;
    }

    public static Result Failure(ResultCode resultCode) {
        Result result = Failure();
        result.setResponseCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        return result;
    }

    public static Result Failure(String msg, int responseCode) {
        Result result = Failure();
        result.setMessage(msg);
        result.setResponseCode(responseCode);
        return result;
    }

    public static Result Success() {
        Result result = new Result();
        result.setStatus(true);
        // 成功的ResponseCode默认为1
        result.setResponseCode(ResultCode.DEFAULT_SUCCESS.getCode());
        result.setMessage(ResultCode.DEFAULT_SUCCESS.getMessage());
        return result;
    }

    public static Result Success(Object obj) {
        Result result = new Result();
        result.setStatus(true);
        // 成功的ResponseCode默认为1
        result.setResponseCode(ResultCode.DEFAULT_SUCCESS.getCode());
        result.setMessage(ResultCode.DEFAULT_SUCCESS.getMessage());
        result.setEntry(obj);
        return result;
    }

    public static Result Success(Object obj, int responseCode) {
        Result result = Success(obj);
        result.setResponseCode(responseCode);
        return result;
    }

    public static Result Success(int responseCode) {
        Result result = Success();
        result.setResponseCode(responseCode);
        result.setMessage(ResultCode.DEFAULT_SUCCESS.getMessage());
        return result;
    }

}