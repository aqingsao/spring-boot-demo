package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.domain.data.CreateBookReqData;
import com.demo.domain.data.UpdateBookReqData;
import com.demo.domain.entity.BookEntity;

/**
 * @author zhangxiaoqing@kuaishou.com
 * Created on 2020-09-22
 */
public interface BooksService {
    BookEntity createBook(CreateBookReqData createBookReqData);

    Optional<BookEntity> getBook(long id);

    // 分页的查询
    Page<BookEntity> getPageableBooks(String keywords, Pageable pageable);

    // 全部的查询
    List<BookEntity> getAllBooks(String keywords);

    void updateBook(UpdateBookReqData updateBookReqData);

    void deleteBook(long id);
}
