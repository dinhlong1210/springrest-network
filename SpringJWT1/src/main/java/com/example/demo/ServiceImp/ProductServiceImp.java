package com.example.demo.ServiceImp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.FileStorageService;
import com.example.demo.Service.ProductService;

@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	private FileStorageService fileStorage;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product createProduct(Product product,MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		String fileName=fileStorage.storeFile(file);
		product.setUrlImage(fileName);
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
	}
	
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
}
