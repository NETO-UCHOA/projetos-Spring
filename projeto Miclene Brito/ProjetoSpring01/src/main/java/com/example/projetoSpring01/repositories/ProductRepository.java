package com.example.projetoSpring01.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoSpring01.models.ProductModel;

@Repository

public interface ProductRepository extends JpaRepository <ProductModel, UUID>{


}
