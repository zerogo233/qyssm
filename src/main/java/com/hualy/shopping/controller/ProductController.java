package com.hualy.shopping.controller;


import com.hualy.shopping.dao.ProductDao;
import com.hualy.shopping.pojo.Category;
import com.hualy.shopping.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductDao dao;

    @RequestMapping(value = "/api/admin/product", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> addProduct(Product product) {
//        Product product = new Product();
//        String name = req.getParameter("name");
//        String subtitle = req.getParameter("subtitle");
//        String detail = req.getParameter("detail");
//        String price = req.getParameter("price");
//        String stock = req.getParameter("stock");
//        String status = req.getParameter("status");
//        product.setName(name);
//        product.setName(subtitle);
//        product.setName(detail);
//        product.setName(price);
//        product.setName(stock);
//        product.setName(status);
        System.out.println("test product :" + product.getName());
        dao.add(product);
        return JSONResult(0, "", product);
    }

    @RequestMapping(value = "/api/admin/product", method = RequestMethod.PUT)
    @ResponseBody
    private Map<String, Object> editProduct(HttpServletRequest req, HttpServletResponse res) {
        Product product = new Product();
        //String id = req.getParameter("id");
        String name = req.getParameter("name");
        String subtitle = req.getParameter("subtitle");
        String detail = req.getParameter("detail");
        String price = req.getParameter("price");
        String stock = req.getParameter("stock");
        String status = req.getParameter("status");
        //product.setId(Integer.valueOf(id));
        product.setName(name);
        product.setName(subtitle);
        product.setName(detail);
        product.setName(price);
        product.setName(stock);
        product.setName(status);
        dao.edit(product);
        return JSONResult(0, "", product);
    }



    @RequestMapping(value = "/api/admin/product", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteProduct(HttpServletRequest req, HttpServletResponse res,
                                               @RequestParam(value = "id", required = false) int id) {
        Product product = new Product();
        dao.delete(id + "");
        return JSONResult(0, "", product);
    }

    @RequestMapping(value = "/api/admin/product", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getProduct(HttpServletRequest req, HttpServletResponse res, String id) {
        Product product = dao.find(id);
        return JSONResult(0, "", product);
    }

    @RequestMapping(value = "/api/admin/product/list", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getpProductList(HttpServletRequest req, HttpServletResponse res, String id) {
        Map<String, Object> map = new HashMap<>();
        List<Product> productList = dao.findList(map);
        System.out.println("test>>"+productList.get(0).getName());
        return JSONResult(0, "", productList);
    }

    private Map<String, Object> JSONResult(int code, String message, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("message", message);
        result.put("data", data);
        return result;
    }

}
