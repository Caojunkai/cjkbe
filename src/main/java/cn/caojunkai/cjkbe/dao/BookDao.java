package cn.caojunkai.cjkbe.dao;

// Created by Fitz on 2016/12/16.

import cn.caojunkai.cjkbe.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    Book queryById(long id);

    List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);

    int reduceNumber(long bookId);
}
