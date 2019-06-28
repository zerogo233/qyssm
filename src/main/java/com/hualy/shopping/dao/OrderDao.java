package com.hualy.shopping.dao;

import com.hualy.shopping.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    public List<Order> findList(Map<String, Object> queryMap);
}
