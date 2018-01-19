package com.ly.ssm.model;

public class Book {
    private Long id;
    private String bookName;
    private String bookWriter;
    private String Publisher;
    private int isRent;
    private String borrow_person;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public int getIsRent() {
        return isRent;
    }

    public void setIsRent(int isRent) {
        this.isRent = isRent;
    }

    public String getBorrow_person() {
        return borrow_person;
    }

    public void setBorrow_person(String borrow_person) {
        this.borrow_person = borrow_person;
    }
}
