package com.demo.domain.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.demo.constant.BookTypeEnum;
import com.demo.domain.entity.BookEntity;

import lombok.Data;

/**
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

    public BookEntity toEntity() {
        BookEntity entity = new BookEntity();
        entity.setName(this.name);
        entity.setType(this.type);
        entity.setPrice(this.price);
        entity.setCreateUser("xxx");
        entity.setCreateTime(System.currentTimeMillis());
        entity.setUpdateUser("xxx");
        entity.setUpdateTime(System.currentTimeMillis());
        return entity;
    }
}
