package com.cayena.products.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cayena.products.entities.Product;
import com.cayena.products.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductApi {
	
	@Autowired
	ProductRepository productRepository;
	
	/** An endpoint to list all product */
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			List<Product> products = productRepository.findAll();
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(products, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/** An endpoint to see just one product by 'id' */
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/** An endpoint to insert a new product */
	@PostMapping("/products")
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		try {
			Product _product = product;
			_product.setQuantityInStock(0L);
			_product.setUnitPrice(BigDecimal.ZERO);
			_product.setDateOfCreation(new Date());
			_product = productRepository.save(_product);
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/** An endpoint to update a product */
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		Optional<Product> productData = productRepository.findById(id);

		if (productData.isPresent()) {
			Product _product = productData.get();
			_product.setName(product.getName());
			_product.setSupplier(product.getSupplier());
			_product.setUnitPrice(product.getUnitPrice());
			_product.setDateOfTheLastUpdate(new Date());
			return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/** An endpoint to delete a product */
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
		try {
			productRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/** An endpoint to increase or decrease the quantity stock */
	@PutMapping("/products/{id}/update-stock/{quantityToIncreaseDecrease}")
	public ResponseEntity<Product> updateProductStock(@PathVariable("id") long id, @PathVariable("quantityToIncreaseDecrease") long quantityToIncreaseDecrease) {
		Optional<Product> productData = productRepository.findById(id);

		if (productData.isPresent()) {
			Product product = productData.get();
			product.setQuantityInStock(Long.sum(product.getQuantityInStock(), quantityToIncreaseDecrease));
			product.setDateOfTheLastUpdate(new Date());
			return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
