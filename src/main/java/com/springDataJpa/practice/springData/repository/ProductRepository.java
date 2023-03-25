package com.springDataJpa.practice.springData.repository;

import com.springDataJpa.practice.springData.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {

    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
}
