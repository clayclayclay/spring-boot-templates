package com.max.security.service;

import com.max.security.entity.Book;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.annotation.security.RolesAllowed;

/**
 * Class File:BookService
 * Author: Max
 * Created Date: 2017-12-04
 */
public interface BookService
{
    //    @Secured({"ROLE_USER", "ROLE_ADMIN"})
//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public Book getBooks();

    //    @Secured({"ROLE_ADMIN"})
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RolesAllowed({"ROLE_ADMIN"})
    public void saveBook(Book book);

    //    @Secured({"ROLE_ADMIN"})
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RolesAllowed({"ROLE_ADMIN"})
    public Book updateBook(Book book);

    //    @Secured({"ROLE_ADMIN"})
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RolesAllowed({"ROLE_ADMIN"})
    public void deleteBook();


}
