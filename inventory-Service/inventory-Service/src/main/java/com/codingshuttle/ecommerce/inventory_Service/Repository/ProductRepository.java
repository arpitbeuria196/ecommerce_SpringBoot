package com.codingshuttle.ecommerce.inventory_Service.Repository;

import com.codingshuttle.ecommerce.inventory_Service.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
