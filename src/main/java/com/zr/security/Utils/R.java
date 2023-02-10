package com.zr.security.Utils;

import lombok.Data;

@Data
public class R<T> {

    private int code = 200;

    private String msg = "success";

    private T data;

    public static <T> R<T> ok() {
        return ok("请求成功");
    }

    public static <T> R<T> ok(String msg) {
        R<T> R = new R<>();
        R.setMsg(msg);
        return R;
    }

    public static <T> R<T> ok(String msg, T data) {
        R<T> R = new R<>();
        R.setMsg(msg);
        R.setData(data);
        return R;
    }

    public static <T> R<T> ok(T data) {
        R<T> R = new R<>();
        R.setData(data);
        return R;
    }

    public static <T> R<T> error() {
        return error(500, "请求异常");
    }

    public static <T> R<T> error(String msg) {
        return error(500, msg);
    }

    public static <T> R<T> error(int code, String msg) {
        R<T> R = new R<>();
        R.setCode(code);
        R.setMsg(msg);
        return R;
    }
}
