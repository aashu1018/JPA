package com.jpa.JPAPractice;

import com.jpa.JPAPractice.Entities.Product;
import com.jpa.JPAPractice.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaPracticeApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		Product product = Product.builder()
				.sku("nestle1234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		Product savedEntity = productRepository.save(product);
		System.out.println(savedEntity);
	}

	@Test
	void getRespository(){
		List<Product> all = productRepository.findAll();
		System.out.println(all);
	}

	@Test
	void getByTitle(){
		Product temp = productRepository.findByTitle("Pepsi");
		System.out.println(temp);
	}

	@Test
	void getByLik(){
		Product temp = productRepository.findByTitleLike("%Biscuit");
		System.out.println(temp);
	}

//	@Test
//	void getSingleFromRepository(){
//		Optional<Product> temp = productRepository.findByTitleAndPrice("Pepsi", BigDecimal.valueOf(14.4));
//		System.out.println(temp);
//	}

}
