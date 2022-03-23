package com.sami.boot.product.repo;

import com.sami.boot.product.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> {

}
