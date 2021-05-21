package com.product.service;

import com.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductService implements IProductService {

    static Map<Integer,Product> products;
    static {
        products=new HashMap<>();
        products.put(1,new Product(1,"Iphone 12ProMax",2000,"Apple"));
        products.put(2,new Product(2,"Galaxy S12",1000,"Samsung"));
        products.put(3,new Product(3,"Nokia Legend",30,"Nokia"));
        products.put(4,new Product(4,"XiaoMi X10",300,"XiaoMi"));
    }

    @Override
    public void create(Product product) {
         products.put(product.getId(),product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values()) ;
    }

    @Override
    public Product findId(int id) {
        return products.get(id);
    }

    @Override
    public void delete(int id) {
         products.remove(id);
    }
}
