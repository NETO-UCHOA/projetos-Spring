package com.example.projetoSpring01.controlers;

import java.util.Optional;

import org.hibernate.validator.constraints.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.projetoSpring01.dtos.ProductRecordDto;
import com.example.projetoSpring01.models.ProductModel;
import com.example.projetoSpring01.repositories.ProductRepository;

import jakarta.validation.Valid;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;





@RestController

public class ProductController {

@Autowired
ProductRepository productRepository;

@PostMapping("/products")

public ResponseEntity<ProductModel> saveProduct(@RequestBody @ Valid ProductRecordDto productRecordDto){
var productModel = new ProductModel();
BeanUtils.copyProperties(productRecordDto, productModel);
return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));

}

@GetMapping("/products")

public ResponseEntity<java.util.List<ProductModel>> getAllProducts(){
    return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
}

@GetMapping("/products/{id}")
	public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id){
		Optional<ProductModel> productO = productRepository.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		productO.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Products List"));
		return ResponseEntity.status(HttpStatus.OK).body(productO.get());
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
		Optional<ProductModel> productO = productRepository.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		productRepository.delete(productO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
													  @RequestBody @Valid ProductRecordDto productRecordDto) {
		Optional<ProductModel> productO = productRepository.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		var productModel = productO.get();
		BeanUtils.copyProperties(productRecordDto, productModel);
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
	}



}
}




