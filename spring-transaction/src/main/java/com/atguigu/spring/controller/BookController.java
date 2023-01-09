package com.atguigu.spring.controller;

import com.atguigu.spring.service.BookService;
import com.atguigu.spring.service.CheckoutService;
import com.sun.tools.javac.comp.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @date 2022/12/27   21:29
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;

    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }

    public void checkout(Integer userId,Integer[] bookIds){
        checkoutService.checkout(userId,bookIds);
    }
}
