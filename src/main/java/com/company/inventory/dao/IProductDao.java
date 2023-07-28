package com.company.inventory.dao;

import com.company.inventory.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductDao extends CrudRepository<Product, Long> {

    @Query(
            value = "select * from product where name like %?1%",
            nativeQuery = true)
    List<Product> findByNameLike(String name);

    List<Product> findByNameContainingIgnoreCase(String name);
}
