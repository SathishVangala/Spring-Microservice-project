package com.practice.SpringJpaPractice.Repository;

import com.practice.SpringJpaPractice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository <Product,Integer> {


}
