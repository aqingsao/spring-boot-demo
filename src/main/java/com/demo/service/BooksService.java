package com.demo.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.demo.domain.data.CreateBookReqData;
import com.demo.domain.data.UpdateBookReqData;
import com.demo.domain.entity.BookEntity;

/**
 * @author zhangxiaoqing@kuaishou.com
 * Created on 2020-09-22
 */
public interface BooksService {
    BookEntity createBook(CreateBookReqData createBookReqData);

    BookEntity getBook(long id);

    // 分页的查询
    Page<BookEntity> getPageableBooks(Pageable pageable);

    // 全部的查询
    List<BookEntity> getAllBooks();

    void updateBook(UpdateBookReqData updateBookReqData);

    void deleteBook(long id);
}
