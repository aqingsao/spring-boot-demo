package com.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.common.OkStatusMessage;
import com.demo.common.ServiceException;
import com.demo.domain.data.CreateBookReqData;
import com.demo.domain.data.UpdateBookReqData;
import com.demo.domain.entity.BookEntity;
import com.demo.repository.BookRepository;
import com.demo.service.BooksService;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2020-09-22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
@Slf4j
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BookRepository repository;

    public BookEntity createBook(CreateBookReqData createBookReqData) {
        BookEntity entity = createBookReqData.toEntity();
        return repository.save(entity);
    }

    public Optional<BookEntity> getBook(long id) {
        return repository.findById(id);
    }

    public Page<BookEntity> getPageableBooks(String keywords, Pageable pageable) {
        if (Strings.isBlank(keywords)) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").descending());
            return repository.findAll(pageable);
        }
        return repository.findAllByKeywords(keywords, pageable);
    }

    public List<BookEntity> getAllBooks(String keywords) {
        return repository.findAllByKeywords(keywords);
    }

    public void updateBook(UpdateBookReqData updateBookReqData) {
        Optional<BookEntity> entityOptional = repository.findById(updateBookReqData.getId());
        if (!entityOptional.isPresent()) {
            throw ServiceException.of(OkStatusMessage.BOOK_NOT_EXIST);
        }
        BookEntity entity = entityOptional.get();
        entity.setName(updateBookReqData.getName());
        entity.setPrice(updateBookReqData.getPrice());
        entity.setType(updateBookReqData.getType());
        entity.setUpdateTime(System.currentTimeMillis());
        entity.setUpdateUser("xxx");
        repository.save(entity);
    }

    public void deleteBook(long id) {
        Optional<BookEntity> entityOptional = repository.findById(id);
        if (!entityOptional.isPresent()) {
            throw ServiceException.of(OkStatusMessage.BOOK_NOT_EXIST);
        }
        BookEntity entity = entityOptional.get();
        // 这里使用了数据库删除记录，实际可以软删除
        repository.delete(entity);
    }
}
