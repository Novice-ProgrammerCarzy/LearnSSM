package com.atguigu.spring.service;

/**
 * @date 2022/12/27   21:33
 */
public interface BookService {
    /**
     * 买书
     * @param userId
     * @param bookId
     */
    void buyBook(Integer userId, Integer bookId);
}
