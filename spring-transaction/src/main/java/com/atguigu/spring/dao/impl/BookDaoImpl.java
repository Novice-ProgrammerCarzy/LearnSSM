package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @date 2022/12/27   21:30
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql = "SELECT price FROM t_book WHERE book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class,bookId);
        return price;
    }

    @Override
    public void updateStock(Integer bookId) {
        String sql = "UPDATE t_book SET stock = (stock - 1) WHERE book_id = ?";
        jdbcTemplate.update(sql,bookId);
    }

    @Override
    public void updateBalance(Integer userId, Integer price) {
        String sql = "UPDATE t_user_book SET balance = (balance - ?)  WHERE user_id = ? ";
        jdbcTemplate.update(sql,price,userId);
    }
}
