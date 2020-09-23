package com.demo.domain.data;

import com.demo.domain.entity.BookEntity;

import lombok.Data;

/**
 * Created on 2020-09-22
 */
@Data
public class BookRespData {
    private long id;

    private String name;

    private double price;

    public BookRespData(BookEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
    }
}
