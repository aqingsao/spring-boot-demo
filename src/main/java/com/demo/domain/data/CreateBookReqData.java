package com.demo.domain.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.demo.constant.BookTypeEnum;

import lombok.Data;

/**
 * @author zhangxiaoqing@kuaishou.com
 * Created on 2020-09-22
 */
@Data
public class CreateBookReqData {
    @NotBlank
    private String name;

    //前端传入"IT"，通过jackson自动反序列化成BookTypeEnum
    @NotNull
    private BookTypeEnum type;

    private double price;
}
