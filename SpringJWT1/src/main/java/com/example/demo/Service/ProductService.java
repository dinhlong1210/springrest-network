package com.example.demo.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Product;

public interface ProductService {
	Product createProduct(Product product,MultipartFile file) throws IOException;
	List<Product> getAllProduct();
	Product updateProduct(Product product);
	void delete(long id);
}
