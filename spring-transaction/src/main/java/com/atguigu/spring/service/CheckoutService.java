package com.atguigu.spring.service;

/**
 * @date 2022/12/29   0:33
 */
public interface CheckoutService {
    /**
     * 结账
     * @param userId
     * @param bookIds
     */
    void checkout(Integer userId, Integer[] bookIds);
}
