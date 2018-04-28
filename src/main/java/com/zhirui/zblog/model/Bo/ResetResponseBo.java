package com.zhirui.zblog.model.Bo;

public class ResetResponseBo<T> {
    // 服务器响应数据
    private T payload;

    // 请求是否成功
    private boolean success;

    // 错误信息
    private String msg;

    // 状态码
    private int code = -1;

    // 服务器响应时间
    private long timestamp;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ResetResponseBo() {
        this.timestamp = System.currentTimeMillis() / 1000;
    }

    public ResetResponseBo(boolean success) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
    }

    public ResetResponseBo(boolean success, T payload) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.payload = payload;
        this.success = success;
    }

    public ResetResponseBo(boolean success, T payload, int code) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.payload = payload;
        this.success = success;
        this.code = code;
    }

    public ResetResponseBo(boolean success, String msg) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.msg = msg;
    }

    public ResetResponseBo(boolean success, String msg, int code) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.msg = msg;
        this.code = code;
    }

    public static ResetResponseBo ok() {
        return  new ResetResponseBo(true);
    }

    public static <T> ResetResponseBo ok(T payload) {
        return  new ResetResponseBo(true, payload);
    }

    public static <T> ResetResponseBo ok(int code) {
        return  new ResetResponseBo(true, null, code);
    }

    public static <T> ResetResponseBo ok(T payload, int code) {
        return  new ResetResponseBo(true, payload, code);
    }

    public static ResetResponseBo fail() {
        return  new ResetResponseBo(false);
    }

    public static ResetResponseBo fail(String msg) {
        return  new ResetResponseBo(false, msg);
    }

    public static ResetResponseBo fail(int code) {
        return  new ResetResponseBo(false, null, code);
    }

    public static ResetResponseBo fail(int code, String msg) {
        return  new ResetResponseBo(false, msg, code);
    }
}
