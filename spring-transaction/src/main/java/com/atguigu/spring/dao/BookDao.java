package com.atguigu.spring.dao;

/**
 * @date 2022/12/27   21:33
 */
public interface BookDao {
    /**
     * 根据图书id查询价格
     * @param bookId
     * @return
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * 根据图书id更新库存
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 根据用户id和价格更新用户余额
     * @param userId
     * @param price
     */
    void updateBalance(Integer userId, Integer price);
}
