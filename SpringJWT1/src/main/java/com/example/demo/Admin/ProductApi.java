package com.example.demo.Admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Security.Payload.Request.SignupAdminRequest;
import com.example.demo.Security.Payload.Response.MessageResponse;
import com.example.demo.Service.FileStorageService;
import com.example.demo.Service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class ProductApi {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	
	@RequestMapping(value = "/products/addproduct",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createProduct(@RequestParam("file") MultipartFile multipartfile, Product product) throws IOException{
		productService.createProduct(product, multipartfile);
		return ResponseEntity.ok(new MessageResponse("Add product Success"));
	}
	
	@RequestMapping(value = "/products",method = RequestMethod.GET)
	public List<Product> getAllProduct(){
		List<Product> Allproduct=productService.getAllProduct();
		return Allproduct;
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateEmployee(@PathVariable Long id,@RequestBody Product product){
		Product product2=new Product();
		product2.setProductName(product.getProductName());
		product2.setAmount(product.getAmount());
		product2.setPrice(product.getPrice());
		product2.setDescription(product.getDescription());
		Product productUpdate=productService.updateProduct(product2);
		return ResponseEntity.ok(productUpdate);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Product product=productRepo.findByProductId(id);
		productRepo.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
