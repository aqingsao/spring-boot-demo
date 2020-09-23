package com.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.common.OkStatusMessage;
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
    public ResultBody<?> list(@RequestParam(value = "keywords", required = false) String keywords) {
        List<BookEntity> entityList = booksService.getAllBooks(keywords);
        // 把bookEntity转换成BookRespData
        List<BookRespData> books = entityList.stream()
                .map(entity -> new BookRespData(entity))
                .collect(Collectors.toList());

        return ResultBody.success(Collections.singletonMap("books", books));
    }

    /**
     * 分页查询的例子
     */
    @GetMapping(value = "/list")
    public ResultBody<?> page(@RequestParam(value = "keywords", required = false) String keywords,
            Pageable pageable) {
        Page<BookEntity> entities = booksService.getPageableBooks(keywords, pageable);
        // 把bookEntity转换成BookRespData
        Page<BookRespData> books = entities.map(BookRespData::new);

        return ResultBody.success(books);
    }

    /**
     *
     */
    @GetMapping(value = "/detail")
    public ResultBody<?> getBook(@RequestParam() long id) {
        Optional<BookEntity> entity = booksService.getBook(id);
        if (!entity.isPresent()) {
            return ResultBody.error(OkStatusMessage.BOOK_NOT_EXIST);
        }
        BookRespData book = new BookRespData(entity.get());
        return ResultBody.success(book);
    }
}