package com.ly.ssm.service.impl;

import com.ly.ssm.dao.BookDao;
import com.ly.ssm.model.Book;
import com.ly.ssm.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    public List<Book> selectByName(String bookName){
        List<Book> books = bookDao.selectBookByName(bookName);
        return books;
    }

    public Book selectBookById(Long id) {
        Book book = bookDao.selectBookById(id);
        return book;
    }

    public List<Book> selectBookByBorrowPerson(String PersonName) {
        List<Book> books = bookDao.selectBookByBorrowPerson(PersonName);
        return books;
    }

    public List<Book> selectByWriter(String writerName){
        List<Book> books = bookDao.selectBookByWriter(writerName);
        return books;
    }
    public void save(Book book){
        bookDao.save(book);
    }

    public void borrow(Long id,String userName) {
        bookDao.borrow(id,userName);
    }

    public void returnBook(Long id) {
        bookDao.returnBook(id);
    }


}
