package com.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangxiaoqing@kuaishou.com
 * Created on 2020-06-30
 */
@AllArgsConstructor
@Getter
public enum OkStatusMessage implements IStatusMessage {
    OK(200, "success"),
    BOOK_NOT_EXIST(300, "not exist");

    private final int code;
    private final String message;
}
