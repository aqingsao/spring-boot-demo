package com.demo.common;

import java.util.Collections;

/**
 * @Author: tianou
 * @Date: 2019/9/24
 */
public class ServiceException extends RuntimeException {

    private int status;
    private String message;
    private Object data;
    private long timestamp = System.currentTimeMillis() / 1000;

    public static ServiceException of(IStatusMessage statusMessage) {
        return of(statusMessage.getCode(), statusMessage.getMessage());
    }

    public static ServiceException of(int status, String message) {
        return new ServiceException(status, message, Collections.EMPTY_MAP);
    }

    private ServiceException(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

