package com.max.validation.model;

import com.max.validation.annotation.LongDataType;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class File:Book
 * Author: Max
 * Created Date: 2017-11-29
 */
public class Book
{

    @NotNull(message = "{NotEmpty.book.id}")
    private String id;

    @NotNull(message = "{NotEmpty.book.name}")
    @Size(min = 1, max = 5, message = "{OverSize.book.name}")
    private String name;

    @NotNull(message = "{NotEmpty.book.price}")
    @LongDataType(message = "{LongDateType.book.price}")
    private String price;

    @NotNull(message = "{NotEmpty.book.isLatest}")
    @AssertTrue(message = "{AssertTrue.book.isLatest}")
    private Boolean isLatest;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public Boolean isLatest()
    {
        return isLatest;
    }

    public void setLatest(Boolean latest)
    {
        isLatest = latest;
    }
}
