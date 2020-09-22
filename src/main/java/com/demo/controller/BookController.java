package com.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.common.ResultBody;
import com.demo.domain.data.BookRespData;
import com.demo.domain.data.CreateBookReqData;
import com.demo.domain.data.UpdateBookReqData;
import com.demo.domain.entity.BookEntity;
import com.demo.service.BooksService;

/**
 * Controller所有方法均返回ResultBody结构，示例：
 * {status: 0, message: XXX, data: {}}
 *
 * @author zhangxiaoqing@kuaishou.com
 * Created on 2020-09-22
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BooksService booksService;

    @PostMapping(value = "/create")
    public ResultBody<?> createBook(@Validated @RequestBody CreateBookReqData reqData) {
        BookEntity entity = booksService.createBook(reqData);
        return ResultBody.success(Collections.singletonMap("id", entity.getId()));
    }

    @PostMapping(value = "/update")
    public ResultBody<?> updateBook(@Validated @RequestBody UpdateBookReqData reqData) {
        booksService.updateBook(reqData);
        return ResultBody.success(Collections.emptyMap());
    }

    /**
     *
     */
    @GetMapping(value = "/list")
    public ResultBody<?> list() {
        List<BookEntity> books = booksService.getAllBooks();
        // 把bookEntity转换成BookRespData
        List<BookRespData> respDataList = books.stream()
                .map(entity -> new BookRespData(entity))
                .collect(Collectors.toList());

        return ResultBody.success(Collections.singletonMap("books", respDataList));
    }

    /**
     *
     */
    @GetMapping(value = "/detail")
    public ResultBody<?> getBook(@RequestParam() long id) {
        BookRespData book = null;
        return ResultBody.success(book);
    }
}