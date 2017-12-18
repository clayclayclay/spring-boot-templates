package com.max.security.service.impl;

import com.max.security.entity.Book;
import com.max.security.service.BookService;
import org.springframework.stereotype.Service;

/**
 * Class File:BookServiceImpl
 * Author: Max
 * Created Date: 2017-12-04
 */
@Service
public class BookServiceImpl implements BookService
{

    @Override
    public Book getBooks()
    {
        System.out.println("get book");
        return new Book();
    }

    @Override
    public void saveBook(Book book)
    {
        System.out.println("save book");
        return;
    }

    @Override
    public Book updateBook(Book book)
    {
        System.out.println("update book");
        return new Book();
    }

    @Override
    public void deleteBook()
    {
        System.out.println("delete book");
        return;
    }
}
