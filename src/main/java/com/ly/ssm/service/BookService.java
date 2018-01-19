package com.ly.ssm.service;

import com.ly.ssm.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    List<Book> selectByName(String bookName);
    Book selectBookById(Long id);
    List<Book> selectBookByBorrowPerson(String PersonName);
    List<Book> selectByWriter(String writerName);
    void save(Book book);
    void borrow(Long id,String userName);
    void returnBook(Long id);
}
