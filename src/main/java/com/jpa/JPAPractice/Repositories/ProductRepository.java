package com.jpa.JPAPractice.Repositories;

import com.jpa.JPAPractice.Entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String pepsi);

    Product findByTitleLike(String s);

    List<Product> findByTitleOrderByPrice(String title);

    List<Product> findBy(Sort sort);

//    @Query("select e from product where e.title=:1 and e.price=:2")
//    Optional<Product> findByTitleAndPrice(String title, BigDecimal price);
}
