package com.springDataJpa.practice.springData.repository;

import com.springDataJpa.practice.springData.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest() {
//        Product product = new  Product().builder()
//                                                . name("Product1")
//                                                .description("product 1 description")
//                                                .sku("100ABC")
//                                                .price(new BigDecimal(1000))
//                                                .active(true)
//                                                .imageUrl("product1.png")
//                                                 .build();
//
//        Product savedProduct = productRepository.save(product);
//        LocalDateTime time1 = product.getDateCreated();
//        LocalDateTime time2 = product.getLastUpdated();
//
//        System.out.println(savedProduct);
//        System.out.println(savedProduct.getId() +" " + time1 + " " + time2);
        Product product2 = new Product().builder()
                .name("Product2")
                .description("product 2 description")
                .sku("100ABCd")
                .price(new BigDecimal(10000))
                .active(false)
                .imageUrl("product2.png")
                .build();
        Product savedProduct2 = productRepository.save(product2);
        System.out.println(savedProduct2);


    }

    @Test
    void updateProduct() {
        Long id = 1L;
        Product foundProduct = productRepository.findById(id).get();
        foundProduct.setName("updated product 1 ");
        foundProduct.setDescription("updated product 1 description");
        productRepository.save(foundProduct);
    }

    @Test
    void findByIdTest() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllTest() {
        Product product3 = new Product().builder()
                .name("Product3")
                .description("product 3 description")
                .sku("100ABCde")
                .price(new BigDecimal(40000))
                .active(false)
                .imageUrl("product3.png")
                .build();


        Product product4 = new Product().builder()
                .name("Product4")
                .description("product 4 description")
                .sku("100ABCdef")
                .price(new BigDecimal(50000))
                .active(false)
                .imageUrl("product5.png")
                .build();

        productRepository.saveAll(List.of(product3, product4));


    }

    @Test
    void findAllProduct() {
        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });

    }

    @Test
    void deleteByIdTest() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteAllTest() {
        Long id = 3L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAll2Test() {
        Product product1 = productRepository.findById(4L).get();
        Product product2 = productRepository.findById(5L).get();

        productRepository.deleteAll(List.of(product1,product2));

    }

    @Test
    void countTest(){
    long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdTest(){
        Long id = 6L;
        boolean exists = productRepository.existsById(id);
        System.out.println(exists);
    }
    @Test
    void findByDateCreateTest(){
        LocalDateTime startDate = LocalDateTime.of(2023, 3, 19,8,26,42);
        LocalDateTime endDate = LocalDateTime.of(2023, 3, 19,9,19,54);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach((p) -> {
            System.out.println(p.getName());
            System.out.println(p.getId());
        });

    }
    @Test
    void sortingByMultipleFields() {
        String sortBy = "";
    }

}