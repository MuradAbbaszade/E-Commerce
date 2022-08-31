package com.company.daoInter;

import com.company.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDaoInter {
    public List<Product> getAllProducts();
}
