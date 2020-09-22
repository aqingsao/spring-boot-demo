package com.demo.service.impl;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.demo.domain.data.CreateBookReqData;
import com.demo.domain.data.UpdateBookReqData;
import com.demo.domain.entity.BookEntity;
import com.demo.service.BooksService;

/**
 * @author zhangxiaoqing@kuaishou.com
 * Created on 2020-09-22
 */
public class BooksServiceImpl implements BooksService {
    public BookEntity createBook(CreateBookReqData createBookReqData) {
        return null;
    }

    public BookEntity getBook(long id) {
        return null;
    }

    public Page<BookEntity> getPageableBooks(Pageable pageable) {
        return null;
    }

    public List<BookEntity> getAllBooks() {
        return null;
    }

    public void updateBook(UpdateBookReqData updateBookReqData) {

    }

    public void deleteBook(long id) {

    }
}
