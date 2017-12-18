package com.max.security.controller;

import com.max.security.entity.Book;
import com.max.security.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class File:BookController
 * Author: Max
 * Created Date: 2017-12-17
 */
@Controller
public class BookController
{

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseBody
    public Book getBook()
    {
        return bookService.getBooks();
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseBody
    public void saveBook()
    {
        bookService.saveBook(new Book());
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    @ResponseBody
    public Book updateBook()
    {
        return bookService.updateBook(new Book());
    }

    @RequestMapping(value = "/book", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBook()
    {
        bookService.deleteBook();
    }
}
