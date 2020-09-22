package com.demo.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.sql.Update;

import lombok.Data;

/**
 * @author zhangxiaoqing@kuaishou.com
 * Created on 2020-09-22
 */
@Entity
@Data
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Update.class)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

}
