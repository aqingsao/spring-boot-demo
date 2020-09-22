package com.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.constant.BookTypeEnum;
import com.demo.domain.entity.BookEntity;

/**
 * @author mengxianghezhe <mengxianghezhe@kuaishou.com>
 * Created on 2020-09-02
 */
public interface BookRepository extends JpaRepository<BookEntity, Long>, CrudRepository<BookEntity, Long> {
    // 通过类型查找，MyBatis会根据findAllByXXX自动生成SQL
    List<BookEntity> findAllByType(BookTypeEnum type);

    // 自定义查询SQL
    @Query(nativeQuery = true, value = "select * from books where (create_user LIKE %?1% or name LIKE %?1%) order by "
            + "id desc")
    List<BookEntity> findAllByKeywords(String keywords);

    // 一个分页查询的例子
    @Query(nativeQuery = true,
            value = "select * from books where (create_user LIKE %?1% or name LIKE %?1%) /*#pageable*/ order by id "
                    + "desc")
    Page<BookEntity> findAllByKeywords(String keywords, Pageable pageable);
}
