package com.hualy.shopping.dao;

import com.hualy.shopping.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    public Product find(String id);

    public int add(Product product);

    public int edit(Product edit);

    public int delete(String del);

    public List<Product> findList(Map<String, Object> queryMap);

    public int getTotal(Map<String, Object> queryMap);
}
