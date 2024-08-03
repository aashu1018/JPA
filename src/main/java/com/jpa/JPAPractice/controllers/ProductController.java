package com.jpa.JPAPractice.controllers;

import com.jpa.JPAPractice.Entities.Product;
import com.jpa.JPAPractice.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final int PAGE_SIZE = 3;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public List<Product> getAllProducts(){
//        return productRepository.findByTitleOrderByPrice("Pepsi");
//    }

//    @GetMapping
//    public List<Product> getAllProducts(@RequestParam (defaultValue = "id") String sortBy){
//        return productRepository.findBy(Sort.by(sortBy));
//    }

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam (defaultValue = "id") String sortBy,
                                        @RequestParam (defaultValue = "0") Integer pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
        return productRepository.findAll(pageable);
    }
}
