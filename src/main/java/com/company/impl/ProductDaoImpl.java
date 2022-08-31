package com.company.impl;

import com.company.daoInter.ProductDaoInter;
import com.company.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public class ProductDaoImpl implements ProductDaoInter{

    @Override
    @Query("SELECT * FROM product")
    public List<Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
