package com.join.learn.ssm.model;

import io.swagger.annotations.ApiModelProperty;

public class ResultResponse<T> {
    /**
     * 响应消息状态码
     * <p>
     * 0: 成功
     * <p>
     * 1: 失败
     */
    @ApiModelProperty("响应消息状态码, 0:操作成功, 非0:操作失败")
    private String code;

    /**
     * 状态码描述
     */
    @ApiModelProperty("状态码描述")
    private String message;

    /**
     * 响应消息体,由spring转成json消息格式/
     */
    private T data;

    @ApiModelProperty("获取当前系统的时间戳")
    private long timestamp;

    public ResultResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
