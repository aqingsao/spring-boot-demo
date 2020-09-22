package com.demo.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.sql.Update;

import com.demo.constant.BookTypeEnum;

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

    @Column(name = "type")
    private BookTypeEnum type;

    @Column(name = "price")
    private double price;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private Long updateTime;
}
