package com.demo.common;

/**
 * Created on 2020-07-07
 */

import java.io.Serializable;
import java.util.Collections;

public class ResultBody<T> implements Serializable {
    private static final long serialVersionUID = -1092197312347313819L;
    private int status;
    private String message;
    private T data;
    private final int timestamp = (int) (System.currentTimeMillis() / 1000L);

    public ResultBody() { }

    public ResultBody(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResultBody<?> success() {
        return success(Collections.EMPTY_MAP);
    }

    public static <T> ResultBody<T> success(T data) {
        return new ResultBody(OkStatusMessage.OK.getCode(), OkStatusMessage.OK.getMessage(), data);
    }

    public static ResultBody<?> error(IStatusMessage errorCodeMsg) {
        return new ResultBody(errorCodeMsg.getCode(), errorCodeMsg.getMessage(), Collections.EMPTY_MAP);
    }

    public static ResultBody<?> error(int status) {
        return new ResultBody(status, "", Collections.EMPTY_MAP);
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public int getTimestamp() {
        return this.timestamp;
    }
}
